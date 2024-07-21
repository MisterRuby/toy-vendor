dependencies {
    implementation(project(":module-core"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")
}

// Entity, Embeddable, MappedSuperclass annotation 을 사용하는 클래스에 대해 open 상태로 설정
// 코틀린의 클래스는 기본적으로 final 로서 상속이 불가능하다
allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.Embeddable")
    annotation("jakarta.persistence.MappedSuperclass")
}