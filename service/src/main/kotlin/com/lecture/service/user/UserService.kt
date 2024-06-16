package com.lecture.service.user

import com.lecture.config.JwtTokenProvider
import com.lecture.domain.user.User
import com.lecture.domain.user.req.CreateUserReq
import com.lecture.domain.user.res.AuthRes
import com.lecture.exception.*
import com.lecture.repository.user.UserRepository
import com.lecture.service.user.mapper.toEntity
import com.lecture.service.user.mapper.toUser
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
  private val userRepository: UserRepository,
  private val jwtTokenProvider: JwtTokenProvider,
  private val passwordEncoder: PasswordEncoder
) {

  @Transactional
  fun registerUser(createUserDto: CreateUserReq): User {
    if (!isValidPassword(createUserDto.password)) {
      throw ValidationException("비밀번호는 최소 6자 이상 10자 이하이어야 하며, 영문 소문자, 대문자, 숫자 중 최소 두 가지 이상을 포함해야 합니다.")
    }
    if (userRepository.existsByEmail(createUserDto.email)) {
      throw DuplicateException("이미 사용 중인 이메일 주소입니다.")
    }
    return userRepository.save(createUserDto.toEntity(encodePassword(createUserDto.password))).toUser()
  }

  fun login(email: String, password: String): AuthRes {
    val user = userRepository.findByEmail(email)
      ?: throw NotFoundException("사용자를 찾을 수 없습니다.")

    if (!passwordEncoder.matches(password, user.password)) {
      throw InvalidCredentialsException("잘못된 비밀번호입니다.")
    }

    if (!user.usable) {
      throw UnAuthorizedException("사용이 중지된 사용자 입니다.")
    }
    return AuthRes(jwtTokenProvider.createToken(email))
  }

  private fun isValidPassword(password: String): Boolean {
    val pattern = Regex("^(?=.*[a-zA-Z])(?=.*\\d).{6,10}$")
    return pattern.matches(password)
  }

  private fun encodePassword(password: String): String {
    return passwordEncoder.encode(password)
  }
}

