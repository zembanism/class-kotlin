import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  val kotlinVersion = "1.9.24"
  id("org.springframework.boot") version "3.0.6"
  id("io.spring.dependency-management") version "1.1.5"
  id("org.asciidoctor.jvm.convert") version "3.3.2"
  id("org.flywaydb.flyway") version "7.13.0" apply false
  kotlin("plugin.jpa") version kotlinVersion apply false
  kotlin("jvm") version kotlinVersion
  kotlin("plugin.spring") version kotlinVersion
  kotlin("kapt") version kotlinVersion apply false

}

group = "com.assignment"
version = "0.0.1-SNAPSHOT"

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(17)
  }
}

buildscript {
  repositories {
    mavenCentral()
  }
  dependencies {
    classpath(kotlin("gradle-plugin", version = "1.8.10"))
  }
}
allprojects {
  repositories {
    mavenCentral()
  }
}

subprojects {
  apply(plugin = "kotlin")
  apply(plugin = "org.jetbrains.kotlin.plugin.spring")
  apply(plugin = "org.springframework.boot")
  apply(plugin = "io.spring.dependency-management")

  dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.1.0")
    implementation("io.github.microutils:kotlin-logging:2.0.11")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
  }

  tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
  }


  tasks.withType<KotlinCompile> {
    kotlinOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      jvmTarget = "17"
    }
  }

  tasks.withType<Test> {
    useJUnitPlatform()
  }
}

val mainClassPath = "com.class.api.ClassApiApplicationKt"

tasks {
  withType<BootJar> {
    mainClass.set(mainClassPath)
  }
}

