package com.lecture.domain.user

import java.time.OffsetDateTime

data class User(
  val id: Long,
  val email: String,
  val name: String,
  val phoneNumber: String,
  val userType: UserType,
  val usable: Boolean,
  val createdAt: OffsetDateTime,
  val updatedAt: OffsetDateTime
)


