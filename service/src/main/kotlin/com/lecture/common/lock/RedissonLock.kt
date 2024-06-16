package com.lecture.common.lock

import com.lecture.exception.RedisLockTimeoutException
import org.redisson.api.RLock
import org.redisson.api.RedissonClient
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class RedissonLock(
  private val redissonClient: RedissonClient
) {

  var waitTime: Long = 3
  var leaseTime: Long = 1

  fun <R> tryLockWith(
    lockName: String,
    task: () -> R,
  ): R = tryLockWith(
    lockKey = lockName,
    waitTime = waitTime,
    leaseTime = leaseTime,
    task = task
  )

  fun <R> tryLockWith(
    lockKey: String,
    waitTime: Long,
    leaseTime: Long,
    task: () -> R,
  ): R {
    val rLock: RLock = redissonClient.getLock(lockKey)
    val available: Boolean = rLock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS)
    if (!available) {
      throw RedisLockTimeoutException("다른 작업이 수행되고 있습니다.")
    }
    try {
      return task()
    } finally {
      if (rLock.isHeldByCurrentThread) {
        rLock.unlock()
      } else {
        throw RedisLockTimeoutException("작업이 이미 종료되었습니다.")
      }
    }
  }
}
