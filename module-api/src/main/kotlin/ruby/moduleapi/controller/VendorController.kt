package ruby.moduleapi.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ruby.moduleapi.logger
import ruby.moduledomainvendor.request.VendorCreateRequest
import ruby.moduledomainvendor.response.VendorResponse
import ruby.moduledomainvendor.service.VendorService
import ruby.modulevendorlookup.request.VendorLookup
import ruby.modulevendorlookup.service.VendorLookupService

@RestController
@RequestMapping("/vendors")
class VendorController(
    private val vendorService: VendorService,
    private val vendorLookupService: VendorLookupService
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
        val vendorLookup = convertToVendorLookup(request)

        val validate = vendorLookupService.validateVendorLookup(vendorLookup)

        if (validate) {
            vendorService.createVendor(request)
        } else {
            throw RuntimeException("Validate Fail!")
        }
    }

    private fun convertToVendorLookup(request: VendorCreateRequest): VendorLookup {
        return VendorLookup(
            b_no = request.vendorNumber,
            start_dt = request.vendorStartDate,
            p_nm = request.representative,
        )
    }
}