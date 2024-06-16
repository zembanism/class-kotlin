package com.lecture.api.config

import com.lecture.domain.common.ApiResult
import mu.KLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

  companion object : KLogging()

  @ExceptionHandler(RuntimeException::class)
  fun handleRuntimeException(ex: RuntimeException): ResponseEntity<ApiResult<Unit>> {
    logger.error("Application Exception : ${ex.message}", ex)
    val responseData = ApiResult<Unit>(HttpStatus.INTERNAL_SERVER_ERROR, ex.message ?: "Internal Server Error")
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData)
  }
}

