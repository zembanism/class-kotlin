package com.lecture.repository.lecture

import com.lecture.domain.lecture.LectureOrderingType
import com.lecture.domain.lecture.req.LectureSearchReq
import com.lecture.repository.ClassQuerydslRepositorySupport
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

class LectureRepositoryImpl : ClassQuerydslRepositorySupport(LectureEntity::class.java), LectureCustomRepository {

  override fun getPageList(searchInput: LectureSearchReq, pageable: Pageable): Page<LectureEntity> {
    val lecture = QLectureEntity.lectureEntity


    val orderingPath = when (searchInput.orderingType) {
      LectureOrderingType.RECENT -> lecture.createdAt.desc()
      LectureOrderingType.APPLICANT -> lecture.currentCapacity.desc()
      LectureOrderingType.APPLICATION_RATE -> lecture.currentCapacity.divide(lecture.maxCapacity).desc()
    }

    val result = from(lecture)
      .offset(pageable.offset)
      .orderBy(orderingPath, lecture.id.asc(), lecture.usable.desc())
      .limit(pageable.pageSize.toLong())
      .fetchResults()

    return PageImpl(result.results, pageable, result.total)
  }
}
