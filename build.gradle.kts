plugins {
    id("java")
    id("org.springframework.boot") version("3.2.2")
    id("io.spring.dependency-management") version("1.1.4")
}

group = "org.ruletka"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")


    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.modelmapper:modelmapper:3.2.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}