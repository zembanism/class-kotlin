package com.lecture.domain.lecture

enum class LectureOrderingType(val desc: String) {
  RECENT("최근등록순"),
  APPLICANT("신청자 많은순"),
  APPLICATION_RATE("신청률 높은순")
}
