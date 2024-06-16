package com.lecture.repository.lecture

import com.lecture.domain.lecture.req.LectureSearchReq
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface LectureCustomRepository {
  fun getPageList(searchInput: LectureSearchReq, pageable: Pageable): Page<LectureEntity>
}
