package com.lecture.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfig(
  private val jwtTokenFilter: JwtTokenFilter
) {

  private val ignoreURL = arrayOf(
    "/hello",
    "/swagger-ui/**",
    "/api/users/**",
    "/v3/api-docs/**",
    "/favicon.ico",
  )

  @Bean
  fun passwordEncoder(): PasswordEncoder {
    return BCryptPasswordEncoder()
  }

  @Bean
  fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
    return http
      .httpBasic().disable()
      .csrf().disable()
      .exceptionHandling()
      .and()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .authorizeHttpRequests()
      .requestMatchers(*ignoreURL).permitAll()
      .anyRequest().authenticated()
      .and()
      .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter::class.java)
      .build()
  }
}
