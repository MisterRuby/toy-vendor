dependencies {
	implementation(project(":module-core"))
	api(project(":module-vendor-lookup"))		// 외부모듈의 빈들을 컴포넌트 스캔 인식 문제로 implementation 가 아닌 api 로 처리
	api(project(":module-rds"))					// module-domain-vendor 모듈을 의존하는 다른 모듈에게 module-rds 모듈을 노출
	implementation("org.springframework.security:spring-security-crypto")
}