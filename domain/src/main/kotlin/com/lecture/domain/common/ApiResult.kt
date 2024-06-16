package com.lecture.domain.common

import org.springframework.http.HttpStatus

data class ApiResult<T>(
  val status: HttpStatus,
  val message: String?,
  val data: T? = null
){
  constructor() : this(HttpStatus.OK, SUCCESS_MESSAGE, null)

  companion object {
    private const val SUCCESS_MESSAGE = "Success"
    private const val FAIL_MESSAGE = "Fail"
    fun <T> success(): ApiResult<T> {
      return ApiResult(HttpStatus.OK, SUCCESS_MESSAGE, null)
    }

    fun <T> success(body: T): ApiResult<T> {
      return ApiResult(HttpStatus.OK, SUCCESS_MESSAGE, body)
    }

    fun <T> fail(status: HttpStatus): ApiResult<T> {
      return ApiResult(status, FAIL_MESSAGE, null)
    }

    fun <T> fail(body: T, status: HttpStatus): ApiResult<T> {
      return ApiResult(status, FAIL_MESSAGE, body)
    }

    fun <T> fail(status: HttpStatus, message: String?, body: T): ApiResult<T> {
      return ApiResult(status, message, body)
    }
  }
}

