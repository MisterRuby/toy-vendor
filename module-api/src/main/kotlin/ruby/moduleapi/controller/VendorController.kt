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