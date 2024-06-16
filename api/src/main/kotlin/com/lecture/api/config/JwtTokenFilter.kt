package com.lecture.api.config

import com.lecture.config.JwtTokenProvider
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import mu.KLogging
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtTokenFilter(private val jwtTokenProvider: JwtTokenProvider) : OncePerRequestFilter() {

  companion object : KLogging()

  override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
    try {
      val token = jwtTokenProvider.resolveToken(request)
      if (token != null && jwtTokenProvider.validateToken(token)) {
        val authentication = jwtTokenProvider.getAuthentication(token)
        SecurityContextHolder.getContext().authentication = authentication
      }
    } catch (e: RuntimeException) {
      logger.error("Filter Error : ${e.message}", e)
      return
    }

    filterChain.doFilter(request, response)
  }
}

