package com.lecture.domain.user.res

import com.lecture.domain.user.UserType


data class UserRes(
  val id: Long,
  val name: String,
  val email: String,
  val phoneNumber: String,
  val userType: UserType
)

