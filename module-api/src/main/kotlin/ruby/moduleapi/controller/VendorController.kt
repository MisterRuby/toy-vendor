package ruby.moduleapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ruby.moduleapi.logger
import ruby.modulecore.code.VendorRoleCode
import ruby.moduledomainvendor.service.VendorService

@RestController
@RequestMapping("/vendors")
class VendorController(
    private val vendorService: VendorService,
) {
    private val logger = logger()

    // 서비스 레이어에서 DTO 타입으로 제공한다.
    @GetMapping
    fun getVendors(): List<String> {
        return vendorService.getVendors()
    }

    // String 값을 Enum 으로 받을 수 있다.
    @GetMapping("/{role}")
    fun getVendorsTest(@PathVariable role: VendorRoleCode) {
        logger.info("role : {}", role.name)
    }
}