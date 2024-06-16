package com.lecture.domain.user.req

import com.lecture.domain.user.UserType

data class CreateUserReq(
  val name: String,
  val email: String,
  val phoneNumber: String,
  val password: String,
  val userType: UserType
)

