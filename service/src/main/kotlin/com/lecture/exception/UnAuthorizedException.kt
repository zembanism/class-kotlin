package com.lecture.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.FORBIDDEN)
class UnAuthorizedException(message: String) : RuntimeException(message)

