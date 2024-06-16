package com.lecture.service.user.mapper

import com.lecture.domain.user.User
import com.lecture.domain.user.req.CreateUserReq
import com.lecture.repository.user.UserEntity

fun UserEntity.toUser() = User(
  id = id,
  email = email,
  name = name,
  phoneNumber = phoneNumber,
  userType = userType,
  usable = usable,
  createdAt = createdAt,
  updatedAt = updatedAt
)

fun CreateUserReq.toEntity(encodedPassword: String) = UserEntity(
  email = email,
  name = name,
  phoneNumber = phoneNumber,
  password = encodedPassword,
  userType = userType
)
