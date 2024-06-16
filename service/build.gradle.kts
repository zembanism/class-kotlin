plugins {
  kotlin("kapt")
  kotlin("plugin.jpa")
  id("org.flywaydb.flyway")
  id("kotlin-allopen")
}

allOpen {
  annotation("jakarta.persistence.Entity")
  annotation("jakarta.persistence.MappedSuperclass")
  annotation("jakarta.persistence.Embeddable")
}

dependencies {
  implementation(project(":domain"))
  api("org.springframework.boot:spring-boot-starter-security")
  api("org.springframework.boot:spring-boot-starter-data-jpa")
  api("org.springframework.boot:spring-boot-starter-data-redis")
  implementation("org.redisson:redisson-spring-boot-starter:3.20.1")
  api("com.querydsl:querydsl-jpa:5.0.0:jakarta")
  kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
  implementation("org.hibernate.validator:hibernate-validator")
  implementation("io.jsonwebtoken:jjwt:0.9.1")
  implementation("javax.xml.bind:jaxb-api:2.3.1")
  runtimeOnly("com.mysql:mysql-connector-j")
  compileOnly("io.swagger.core.v3:swagger-core-jakarta:2.2.19")
}

flyway {
  url = "jdbc:mysql://localhost:3306/class"
  user = "root"
  password = "root"
}
