package com.lecture.domain.lecture.req

import com.lecture.domain.common.PageInput
import com.lecture.domain.lecture.LectureOrderingType

data class LectureSearchReq(
  val pageInput: PageInput,
  val orderingType: LectureOrderingType = LectureOrderingType.RECENT
)
