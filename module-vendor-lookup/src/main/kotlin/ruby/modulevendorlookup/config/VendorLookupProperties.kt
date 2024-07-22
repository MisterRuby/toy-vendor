package ruby.modulevendorlookup.config

import jakarta.validation.constraints.NotBlank
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated

@ConfigurationProperties(prefix = "vendor.lookup")
@Validated
data class VendorLookupProperties(
    @field:NotBlank val url: String,
    @field:NotBlank val serviceKey: String,
    @field:NotBlank val returnType: String
)