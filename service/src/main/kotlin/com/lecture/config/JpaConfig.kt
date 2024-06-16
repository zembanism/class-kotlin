package com.lecture.config

import com.lecture.repository.JpaEntityMarker
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.auditing.DateTimeProvider
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.time.OffsetDateTime
import java.util.Optional.of

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  basePackageClasses = [JpaEntityMarker::class]
)
class JpaConfig {
  @Bean
  fun auditingDateTimeProvider() = DateTimeProvider { of(OffsetDateTime.now()) }
}
