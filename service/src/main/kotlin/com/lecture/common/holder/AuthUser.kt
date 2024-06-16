package com.lecture.common.holder

import com.lecture.domain.user.UserType
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class AuthUser(
  val userId: Long,
  val userLoginId: String,
  val name: String,
  val userType: UserType,
  val phoneNumber: String
) : UserDetails {
  override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
    return arrayListOf(SimpleGrantedAuthority("TEST_ROLE"))
  }

  override fun getPassword(): String {
    return ""
  }

  override fun getUsername(): String {
    return name
  }

  override fun isAccountNonExpired(): Boolean {
    return true
  }

  override fun isAccountNonLocked(): Boolean {
    return true
  }

  override fun isCredentialsNonExpired(): Boolean {
    return true
  }

  override fun isEnabled(): Boolean {
    return true
  }
}
