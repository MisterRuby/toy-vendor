package ruby.moduledomainvendor.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ruby.modulerds.entity.Vendor
import ruby.modulerds.repository.VendorRepository

/**
 * 코틀린에서는 주생성자로 의존성을 @Autowired 없이 주입받을 수 있다.
 */
@Service
class VendorService(
    private val vendorRepository: VendorRepository
) {
    fun getVendors() : List<String> {
        createVendor()

        return vendorRepository.findAll().map { it.vendorNumber }
    }

    @Transactional
    fun createVendor() {
        vendorRepository.save(Vendor(
            vendorNumber = "0000000000",
            vendorName = "",
            vendorStartDate = "",
            representative = "",
            address = ""
        ))
    }
}