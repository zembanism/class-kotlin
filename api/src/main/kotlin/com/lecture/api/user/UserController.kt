package com.lecture.api.user

import com.lecture.domain.common.ApiResult
import com.lecture.domain.user.req.CreateUserReq
import com.lecture.domain.user.req.LoginReq
import com.lecture.domain.user.res.AuthRes
import com.lecture.domain.user.res.UserRes
import com.lecture.service.user.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(
  private val userService: UserService
) {

  @PostMapping("/register")
  fun registerUser(@RequestBody input: CreateUserReq): ApiResult<UserRes> {
    val user = userService.registerUser(input)
    return ApiResult.success(UserRes(user.id, user.name, user.email, user.phoneNumber, user.userType))
  }

  @PostMapping("/login")
  fun login(@RequestBody input: LoginReq): ApiResult<AuthRes> {
    val authRes = userService.login(input.email, input.password)
    return ApiResult.success(authRes)
  }
}

