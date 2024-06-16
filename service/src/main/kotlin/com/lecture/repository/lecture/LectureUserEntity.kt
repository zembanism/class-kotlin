package com.lecture.repository.lecture

import com.lecture.repository.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "lecture_users")
data class LectureUserEntity(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0,

  @Column(name = "lecture_id")
  val lectureId: Long,

  @Column(name = "user_id")
  val userId: Long
) : BaseEntity()

