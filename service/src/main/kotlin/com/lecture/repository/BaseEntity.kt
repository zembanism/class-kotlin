package com.lecture.repository

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.OffsetDateTime

@MappedSuperclass
abstract class BaseEntity {

  @CreatedDate
  @Column(name = "created_at", updatable = false, nullable = false)
  var createdAt: OffsetDateTime = OffsetDateTime.now()
    protected set

  @LastModifiedDate
  @Column(name = "updated_at", nullable = false)
  var updatedAt: OffsetDateTime = OffsetDateTime.now()
    protected set
}
