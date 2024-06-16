package com.kakaostyle.wms.api

import com.lecture.ServiceConfigurationLoader
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(
  value = [
    ServiceConfigurationLoader::class
  ]
)
class WmsApiApplication

fun main(args: Array<String>) {
  runApplication<WmsApiApplication>(*args)
}
