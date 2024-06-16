package com.lecture.domain.lecture.res

import java.math.BigDecimal
import java.time.OffsetDateTime

data class LectureViewResult(
  val lectureId: Long,
  val lectureName: String,
  val price: BigDecimal,
  val instructorName: String,
  val maxCapacity: Int,
  val currentCapacity: Int,
  val usable: Boolean,
  val createdAt: OffsetDateTime,
  val updatedAt: OffsetDateTime
)
