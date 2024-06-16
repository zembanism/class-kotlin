package com.lecture.service.user

import com.lecture.common.holder.AuthUser
import com.lecture.exception.NotFoundException
import com.lecture.repository.user.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthUserService(private val userRepository: UserRepository) : UserDetailsService {
  override fun loadUserByUsername(userLoginId: String): UserDetails {
    val user = userRepository.findByEmail(userLoginId) ?: throw NotFoundException("사용자 정보가 없습니다.")
    return AuthUser(
      userId = user.id,
      userLoginId = user.email,
      name = user.name,
      phoneNumber = user.phoneNumber,
      userType = user.userType
    )
  }
}
