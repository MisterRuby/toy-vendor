dependencies {
    implementation(project(":module-core"))
    implementation(project(":module-domain-vendor"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.getByName("bootJar") {
    enabled = true
}