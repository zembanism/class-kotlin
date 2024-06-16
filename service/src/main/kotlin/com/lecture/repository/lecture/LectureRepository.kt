package com.lecture.repository.lecture

import org.springframework.data.jpa.repository.JpaRepository

interface LectureRepository : JpaRepository<LectureEntity, Long>, LectureCustomRepository {
  fun existsByName(name: String): Boolean
}

