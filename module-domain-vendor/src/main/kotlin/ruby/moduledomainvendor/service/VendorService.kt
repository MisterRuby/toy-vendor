package ruby.moduledomainvendor.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ruby.moduledomainvendor.exception.DuplicateVendorException
import ruby.moduledomainvendor.request.VendorCreateRequest
import ruby.moduledomainvendor.response.VendorResponse
import ruby.modulerds.entity.Vendor
import ruby.modulerds.entity.VendorRole
import ruby.modulerds.entity.enbeddable.VendorRoleId
import ruby.modulerds.repository.VendorRepository
import ruby.modulerds.repository.VendorRoleRepository

/**
 * 코틀린에서는 주생성자로 의존성을 @Autowired 없이 주입받을 수 있다.
 */
@Service
class VendorService(
    private val vendorRepository: VendorRepository,
    private val vendorRoleRepository: VendorRoleRepository
) {
    fun getAllVendors() : List<VendorResponse> {
        return vendorRepository.findAllWithRoles().map { convertToResponse(it) }
    }

    @Transactional
    fun createVendor(request: VendorCreateRequest) : VendorResponse {
        if (checkDuplicateVendor(request.vendorNumber)) {
            throw DuplicateVendorException()
        }

        val saveVendor = vendorRepository.save(
            Vendor(
                vendorNumber = request.vendorNumber,
                vendorName = request.vendorName,
                vendorStartDate = request.vendorStartDate,
                representative = request.representative,
                address = request.address
            )
        )

        request.roles.forEach {
            val vendorRoleId = VendorRoleId(saveVendor.id, it)
            val vendorRole = VendorRole(vendorRoleId, saveVendor)
            vendorRoleRepository.save(vendorRole)
        }

        // TODO - 마스터 사용자 정보 저장. 계정 역할을 마스터로 고정. 해당 계정은 변경 및 삭제 불가. 비밀번호는 단방향 암호화 적용.

        return convertToResponse(saveVendor)
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
        return vendorRepository.findByVendorNumber(vendorNumber) != null
    }
}