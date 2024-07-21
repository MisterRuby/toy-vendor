dependencies {
	implementation(project(":module-core"))
	api(project(":module-rds"))					// module-domain-vendor 모듈을 의존하는 다른 모듈에게 module-rds 모듈을 노출
}