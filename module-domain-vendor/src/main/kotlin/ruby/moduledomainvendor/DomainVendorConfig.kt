package ruby.moduledomainvendor

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import ruby.modulerds.JpaAuditingConfig
import ruby.modulevendorlookup.VendorLookupConfig

@Configuration
@ComponentScan(basePackages = ["ruby.moduledomainvendor"])      // @SpringbootApplication 을 사용하지 않는 모듈에서 @ComponentScan 을 통해 스캔 범위를 지정
@Import(VendorLookupConfig::class, JpaAuditingConfig::class)    // 지정한 @Configuration 의 빈들도 등록
class DomainVendorConfig