package com.lecture.repository.lecture

import org.springframework.data.jpa.repository.JpaRepository

interface LectureUserRepository : JpaRepository<LectureUserEntity, Long>
