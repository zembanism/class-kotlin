package com.lecture.api.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfig {
  @Bean
  fun openAPI(): OpenAPI {
    val info: Info = Info()
      .version("v1.0.0")
      .title("API")
      .description("")

    val jwt = "JWT"
    val securityRequirement: SecurityRequirement = SecurityRequirement().addList(jwt) // 헤더에 토큰 포함
    val components = Components().addSecuritySchemes(
      jwt, SecurityScheme()
        .name(jwt)
        .type(SecurityScheme.Type.HTTP)
        .scheme("bearer")
        .bearerFormat("JWT")
    )

    return OpenAPI()
      .info(info)
      .addSecurityItem(securityRequirement)
      .components(components)
  }
}
