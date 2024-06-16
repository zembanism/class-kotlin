package com.lecture.common.holder

import com.lecture.exception.UnAuthorizedException
import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope

@Component
@RequestScope
class UserHolder {
  var userId: String? = null

  fun update(userLoginId: String): UserHolder {
    userId = userLoginId
    return this
  }

  fun getUserLoginIdOrThrow(): String {
    return userId ?: throw UnAuthorizedException("로그인 정보가 없습니다. 로그인 해주세요.")
  }
}
