package com.lecture.repository

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport

class ClassQuerydslRepositorySupport(domainClass: Class<*>) : QuerydslRepositorySupport(domainClass) {

  @PersistenceContext
  override fun setEntityManager(entityManager: EntityManager) {
    super.setEntityManager(entityManager)
  }
}
