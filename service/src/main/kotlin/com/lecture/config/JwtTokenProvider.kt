package com.lecture.config

import com.lecture.service.user.AuthUserService
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.time.Duration
import java.util.*

@Component
class JwtTokenProvider(
  private val authUserService: AuthUserService
) {

  @Value("\${security.jwt.token.secret-key}")
  private lateinit var secretKey: String

  private val accessTokenExpireTime = Duration.ofHours(1)

  fun createToken(email: String): String {
    val claims = Jwts.claims().setSubject(email)
    claims["loginId"] = email

    val now = Date()
    return Jwts.builder()
      .setClaims(claims)
      .setIssuedAt(now)
      .setExpiration(Date(now.time + accessTokenExpireTime.toMillis()))
      .signWith(SignatureAlgorithm.HS256, secretKey)
      .compact()
  }

  fun validateToken(token: String): Boolean {
    try {
      Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
      return true
    } catch (e: JwtException) {
      return false
    } catch (e: IllegalArgumentException) {
      return false
    }
  }

  fun resolveToken(request: HttpServletRequest): String? {
    val bearerToken = request.getHeader("Authorization")
    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7)
    }
    return null
  }

  fun getUserId(token: String): String {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).body.subject
  }

  fun getAuthentication(token: String): Authentication {
    val userId = getUserId(token)
    val userDetails: UserDetails = authUserService.loadUserByUsername(userId)
    return UsernamePasswordAuthenticationToken(userDetails, token, userDetails.authorities)
  }
}

