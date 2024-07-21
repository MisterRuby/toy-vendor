package ruby.moduledomainvendor.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ruby.moduledomainvendor.exception.DuplicateVendorException
import ruby.moduledomainvendor.request.VendorCreateRequest
import ruby.moduledomainvendor.response.VendorResponse
import ruby.modulerds.entity.Vendor
import ruby.modulerds.repository.VendorRepository

/**
 * 코틀린에서는 주생성자로 의존성을 @Autowired 없이 주입받을 수 있다.
 */
@Service
class VendorService(
    private val vendorRepository: VendorRepository
) {
    private fun convertToResponse(vendor: Vendor): VendorResponse {
        return VendorResponse(
            id = vendor.id,
            vendorNumber = vendor.vendorNumber,
            vendorName = vendor.vendorName,
            vendorStartDate = vendor.vendorStartDate,
            representative = vendor.representative,
            address = vendor.address,
            roles = vendor.roles
        )
    }

    fun getAllVendors() : List<VendorResponse> {
        return vendorRepository.findAll().map { convertToResponse(it) }
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

        // TODO - 벤더 역할을 저장
        request.roles.forEach {  }

        // TODO - 마스터 사용자 정보 저장. 계정 역할을 마스터로 고정. 해당 계정은 변경 및 삭제 불가

        return convertToResponse(saveVendor)
    }

    private fun checkDuplicateVendor(vendorNumber: String) : Boolean {
        return vendorRepository.findByVendorNumber(vendorNumber) != null
    }
}