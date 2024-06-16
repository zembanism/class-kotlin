package com.lecture.repository.user

import com.lecture.domain.user.UserType
import com.lecture.repository.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0,

  @Column(nullable = false)
  val name: String,

  @Column(nullable = false, unique = true)
  val email: String,

  @Column(nullable = false)
  val phoneNumber: String,

  @Column(nullable = false)
  val password: String,

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  val userType: UserType,

  @Column(nullable = false)
  val usable: Boolean = true
) : BaseEntity()
