package ruby.moduleapi.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ruby.moduleapi.logger
import ruby.moduledomainvendor.request.VendorCreateRequest
import ruby.moduledomainvendor.response.VendorResponse
import ruby.moduledomainvendor.service.VendorService

@RestController
@RequestMapping("/vendors")
class VendorController(
    private val vendorService: VendorService
) {
    private val logger = logger()

    // 서비스 레이어에서 DTO 타입으로 제공한다.
    @GetMapping
    fun getAllVendors(): List<VendorResponse> {
        return vendorService.getAllVendors()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createVendor(@RequestBody request: VendorCreateRequest) {
        vendorService.createVendor(request)
    }
}