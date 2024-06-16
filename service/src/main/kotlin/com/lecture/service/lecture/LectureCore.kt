package com.lecture.service.lecture

import com.lecture.common.lock.RedissonLock
import com.lecture.exception.CapacityFullException
import com.lecture.exception.NotFoundException
import com.lecture.exception.ValidationException
import com.lecture.repository.lecture.LectureRepository
import com.lecture.repository.lecture.LectureUserEntity
import com.lecture.repository.lecture.LectureUserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class LectureCore(
  private val lectureRepository: LectureRepository,
  private val lectureUserRepository: LectureUserRepository,
  private val redissonLock: RedissonLock
) {

  companion object {
    const val LECTURE_LOCK_PREFIX = "LECTURE_"
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  fun applyLecture(lectureId: Long, userId: Long) {
    val lecture = lectureRepository.findByIdOrNull(lectureId)
      ?: throw NotFoundException("강의를 찾을수 없습니다.")

    if (lecture.user.id == userId) {
      throw ValidationException("본인이 개셜한 강의는 수강할수 없습니다.")
    }

    if (lecture.maxCapacity <= lecture.currentCapacity) {
      throw CapacityFullException("마감되었습니다.")
    }

    redissonLock.tryLockWith(lockName = "$LECTURE_LOCK_PREFIX$lectureId") {
      lecture.currentCapacity++
      lectureUserRepository.save(LectureUserEntity(lectureId = lectureId, userId = userId))
    }
  }
}
