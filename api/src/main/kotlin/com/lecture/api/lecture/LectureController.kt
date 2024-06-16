package com.lecture.api.lecture

import com.lecture.domain.common.ApiResult
import com.lecture.domain.common.PageResult
import com.lecture.domain.lecture.Lecture
import com.lecture.domain.lecture.req.ApplyLecturesReq
import com.lecture.domain.lecture.req.CreateLectureReq
import com.lecture.domain.lecture.req.LectureSearchReq
import com.lecture.domain.lecture.res.LectureViewResult
import com.lecture.service.lecture.LectureService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/lectures")
class LectureController(private val lectureService: LectureService) {

  @PostMapping("/register")
  fun registerLecture(@RequestBody input: CreateLectureReq): ApiResult<Lecture> {
    return ApiResult.success(lectureService.registerLecture(input))
  }

  @PostMapping("/list")
  fun getList(
    @RequestBody searchInput: LectureSearchReq
  ): ApiResult<PageResult<LectureViewResult>> {
    return ApiResult.success(lectureService.getPageList(searchInput))
  }

  @PostMapping("/apply")
  fun applyForLectures(@RequestBody input: ApplyLecturesReq): ApiResult<String> {
    return ApiResult.success(lectureService.applyLectureList(input.lectureIds))
  }
}

