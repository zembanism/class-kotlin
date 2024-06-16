package com.lecture.config

import org.redisson.Redisson
import org.redisson.api.RedissonClient
import org.redisson.config.Config
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RedissonConfig {

  @Bean
  fun redissonClient(): RedissonClient {
    val config = Config()
    config.useSingleServer().address = "redis://localhost:6379"
    return Redisson.create(config)
  }
}

