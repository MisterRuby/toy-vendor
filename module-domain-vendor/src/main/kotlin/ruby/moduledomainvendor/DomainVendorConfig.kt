package ruby.moduledomainvendor

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = [
    "ruby.modulerds",                   // Repository 계층
    "ruby.moduledomainvendor",          // Service 계층
    "ruby.modulevendorlookup"           // Service 계층
])
class DomainVendorConfig