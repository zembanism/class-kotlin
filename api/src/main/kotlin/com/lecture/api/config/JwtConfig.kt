package com.lecture.api.config

import com.lecture.config.JwtTokenProvider
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class JwtConfig(private val jwtTokenProvider: JwtTokenProvider) :
  SecurityConfigurerAdapter<DefaultSecurityFilterChain?, HttpSecurity>() {
  @Throws(Exception::class)
  override fun configure(builder: HttpSecurity) {
    val filter = JwtTokenFilter(jwtTokenProvider)
    builder.addFilterBefore(filter, UsernamePasswordAuthenticationFilter::class.java)
  }
}
