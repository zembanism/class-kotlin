package com.lecture.domain.lecture.req

import java.math.BigDecimal

data class CreateLectureReq(
  val name: String,
  val maxCapacity: Int,
  val price: BigDecimal
)

