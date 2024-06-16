package com.lecture.service.lecture

import com.lecture.common.holder.UserHolder
import com.lecture.domain.common.PageInput
import com.lecture.domain.common.PageResult
import com.lecture.domain.lecture.Lecture
import com.lecture.domain.lecture.LectureStatus
import com.lecture.domain.lecture.req.CreateLectureReq
import com.lecture.domain.lecture.req.LectureSearchReq
import com.lecture.domain.lecture.res.LectureViewResult
import com.lecture.domain.user.UserType
import com.lecture.exception.DuplicateException
import com.lecture.exception.NotFoundException
import com.lecture.exception.UnAuthorizedException
import com.lecture.exception.ValidationException
import com.lecture.repository.lecture.LectureEntity
import com.lecture.repository.lecture.LectureRepository
import com.lecture.repository.user.UserEntity
import com.lecture.repository.user.UserRepository
import com.lecture.service.lecture.mapper.toLecture
import mu.KLogging
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LectureService(
  private val userRepository: UserRepository,
  private val lectureRepository: LectureRepository,
  private val userHolder: UserHolder,
  private val lectureCore: LectureCore
) {

  companion object : KLogging()

  fun PageInput.toPageable(): PageRequest {
    return if (pageSize == 0) {
      PageRequest.of(pageNo, 20)
    } else {
      PageRequest.of(pageNo, pageSize)
    }
  }

  fun getPageList(searchInput: LectureSearchReq): PageResult<LectureViewResult> {

    val page = lectureRepository.getPageList(searchInput = searchInput, pageable = searchInput.pageInput.toPageable())
    return PageResult(
      totalPage = page.totalPages,
      totalCount = page.totalElements,
      size = page.size,
      page = page.number,
      list = page.content.map {
        LectureViewResult(
          lectureId = it.id,
          lectureName = it.name,
          price = it.price,
          instructorName = it.user.name,
          maxCapacity = it.maxCapacity,
          currentCapacity = it.currentCapacity,
          usable = it.usable,
          createdAt = it.createdAt,
          updatedAt = it.updatedAt
        )
      }
    )
  }

  @Transactional
  fun registerLecture(input: CreateLectureReq): Lecture {
    val userLoginId = userHolder.getUserLoginIdOrThrow()
    val instructor = userRepository.findByEmail(userLoginId) ?: throw NotFoundException("강사를 찾을 수 없습니다.")

    if (instructor.userType != UserType.INSTRUCTOR) {
      throw UnAuthorizedException("강의 등록 권한이 없는 사용자입니다.")
    }

    isUsableUser(instructor)

    val existLecture = lectureRepository.existsByName(input.name)
    if (existLecture) {
      throw DuplicateException("중복된 강의 이름입니다.")
    }

    if (input.maxCapacity < 1) {
      throw ValidationException("강의 최대 이용자는 1보다 작을수 없습니다.")
    }

    val lecture = LectureEntity(
      name = input.name,
      status = LectureStatus.OPEN,
      maxCapacity = input.maxCapacity,
      price = input.price,
      user = instructor
    )
    return lectureRepository.save(lecture).toLecture()
  }

  @Transactional(readOnly = true)
  fun applyLectureList(lectureIdList: List<Long>): String {
    val userLoginId = userHolder.getUserLoginIdOrThrow()
    val user = userRepository.findByEmail(userLoginId) ?: throw NotFoundException("회원을 찾을 수 없습니다.")

    isUsableUser(user)

    var successList = mutableListOf<Long>()
    var failList = mutableListOf<Long>()
    lectureIdList.forEach {
      try {
        lectureCore.applyLecture(it, user.id)
        successList.add(it)
      } catch (e: RuntimeException) {
        logger.error("ID: $it, Apply Exception : ${e.message}", e)
        failList.add(it)
      }
    }
    return "Success Id List : ${successList.joinToString()}, Fail Id List : ${failList.joinToString()}"
  }

  private fun isUsableUser(user: UserEntity) {
    if (!user.usable) {
      throw UnAuthorizedException("사용이 중지된 사용자입니다.")
    }
  }
}

