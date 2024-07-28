package ruby.modulevendorlookup.config

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import ruby.modulevendorlookup.service.VendorLookupService

@Configuration
@EnableConfigurationProperties(VendorLookupProperties::class)
class VendorLookupPropertiesConfig(
    private val vendorLookupProperties: VendorLookupProperties
) {

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

    @Bean
    fun vendorLookupService(): VendorLookupService {
        return VendorLookupService(restTemplate(), vendorLookupProperties)
    }
}