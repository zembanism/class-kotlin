package com.lecture.service.lecture.mapper

import com.lecture.domain.lecture.Lecture
import com.lecture.repository.lecture.LectureEntity
import com.lecture.service.user.mapper.toUser

fun LectureEntity.toLecture() = Lecture(
  id = id,
  name = name,
  maxCapacity = maxCapacity,
  currentCapacity = currentCapacity,
  price = price,
  user = user.toUser(),
  usable = usable,
  createdAt = createdAt,
  updatedAt = updatedAt
)
