dependencies {
    implementation(project(":module-core"))
    implementation(project(":module-domain-vendor"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}

tasks.getByName("bootJar") {
    enabled = true
}