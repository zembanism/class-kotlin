package com.lecture.api.config

import com.lecture.common.holder.AuthUser
import com.lecture.common.holder.UserHolder
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class AuthenticateInterceptor(private val userHolder: UserHolder) : HandlerInterceptor {

  companion object {
    const val ANONYMOUS_USER = "anonymousUser"
  }

  override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
    if (SecurityContextHolder.getContext().authentication.principal != ANONYMOUS_USER) {
      val authUser = SecurityContextHolder.getContext().authentication.principal as AuthUser
      userHolder.update(authUser.userLoginId)
    }
    return super.preHandle(request, response, handler)
  }
}
