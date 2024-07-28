package ruby.moduledomainvendor.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ruby.modulecore.code.VendorStatusCode
import ruby.modulecore.code.VendorUserRoleCode
import ruby.moduledomainvendor.exception.VendorDuplicateException
import ruby.moduledomainvendor.exception.VendorVerificationException
import ruby.moduledomainvendor.request.VendorCreateRequest
import ruby.moduledomainvendor.request.VendorUserCreateRequest
import ruby.moduledomainvendor.response.VendorResponse
import ruby.modulerds.entity.Vendor
import ruby.modulerds.entity.VendorRole
import ruby.modulerds.entity.enbeddable.VendorRoleId
import ruby.modulerds.repository.VendorRepository
import ruby.modulerds.repository.VendorRoleRepository
import ruby.modulevendorlookup.request.VendorLookup
import ruby.modulevendorlookup.service.VendorLookupService

/**
 * 코틀린에서는 주생성자로 의존성을 @Autowired 없이 주입받을 수 있다.
 */
@Service
class VendorService(
    private val vendorRepository: VendorRepository,
    private val vendorRoleRepository: VendorRoleRepository,
    private val vendorLookupService: VendorLookupService,
    private val vendorUserService: VendorUserService
) {
    fun getAllVendors() : List<VendorResponse> {
        return vendorRepository.findAllWithRoles().map { convertToResponse(it) }
    }

    @Transactional
    fun createVendor(request: VendorCreateRequest) {
        if (checkDuplicateVendor(request.vendorNumber)) {
            throw VendorDuplicateException()
        }

        val vendorLookup = convertToVendorLookup(request)

        val validate = vendorLookupService.validateVendorLookup(vendorLookup)
        if (!validate) throw VendorVerificationException()

        val saveVendor = vendorRepository.save(
            Vendor(
                vendorNumber = request.vendorNumber,
                vendorName = request.vendorName,
                vendorStartDate = request.vendorStartDate,
                representative = request.representative,
                address = request.address,
                status = VendorStatusCode.READY
            )
        )

        request.roles.forEach {
            val vendorRoleId = VendorRoleId(saveVendor.id, it)
            val vendorRole = VendorRole(vendorRoleId, saveVendor)
            vendorRoleRepository.save(vendorRole)
        }

        vendorUserService.createVendorUser(VendorUserCreateRequest(
            username = request.masterUsername,
            userId = request.masterUserId,
            password = request.masterPassword,
            roles = listOf(VendorUserRoleCode.MASTER),
            vendor = saveVendor
        ))
    }

    private fun convertToResponse(vendor: Vendor): VendorResponse {
        return VendorResponse(
            id = vendor.id,
            vendorNumber = vendor.vendorNumber,
            vendorName = vendor.vendorName,
            vendorStartDate = vendor.vendorStartDate,
            representative = vendor.representative,
            address = vendor.address,
            roles = vendor.roles.map { it.id.role.name }
        )
    }

    private fun checkDuplicateVendor(vendorNumber: String) : Boolean {
        return vendorRepository.existsByVendorNumber(vendorNumber)
    }

    private fun convertToVendorLookup(request: VendorCreateRequest): VendorLookup {
        return VendorLookup(
            b_no = listOf(request.vendorNumber),
        )
    }
}