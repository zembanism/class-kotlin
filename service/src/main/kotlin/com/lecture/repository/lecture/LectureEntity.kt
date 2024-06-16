package com.lecture.repository.lecture

import com.lecture.domain.lecture.LectureStatus
import com.lecture.repository.BaseEntity
import com.lecture.repository.user.UserEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "lectures")
data class LectureEntity(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0,

  @Column(nullable = false)
  val name: String,

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  val status: LectureStatus,

  @Column(name = "enrolment_limit_count")
  val maxCapacity: Int = 0,

  @Column(name = "enrolment_count")
  var currentCapacity: Int = 0,

  @Column(nullable = false)
  var price: BigDecimal = BigDecimal.ZERO,

  @ManyToOne
  @JoinColumn(name = "user_id")
  val user: UserEntity,

  @Column(nullable = false)
  var usable: Boolean = true
) : BaseEntity() {
  @Version
  var version: Long = 0
}

