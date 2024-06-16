package com.lecture.domain.lecture

import com.lecture.domain.user.User
import java.math.BigDecimal
import java.time.OffsetDateTime

data class Lecture(
  val id: Long,
  val name: String,
  val maxCapacity: Int,
  val currentCapacity: Int,
  val price: BigDecimal,
  val user: User,
  val usable: Boolean,
  val createdAt: OffsetDateTime,
  val updatedAt: OffsetDateTime
)
