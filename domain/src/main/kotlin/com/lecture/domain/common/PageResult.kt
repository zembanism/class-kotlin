package com.lecture.domain.common

data class PageResult<T>(
  val totalPage: Int,
  val totalCount: Long,
  val size: Int,
  val page: Int,
  val list: List<T>
)
