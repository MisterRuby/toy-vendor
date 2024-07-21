package ruby.moduledomainvendor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EntityScan("ruby.modulerds.entity")
@EnableJpaRepositories(basePackages = ["ruby.modulerds.repository"])
@SpringBootApplication(scanBasePackages = [
    "ruby.modulerds",                   // Repository 계층
    "ruby.moduledomainvendor",          // Service 계층
])
class ModuleDomainVendorApplication

fun main(args: Array<String>) {
    runApplication<ModuleDomainVendorApplication>(*args)
}
