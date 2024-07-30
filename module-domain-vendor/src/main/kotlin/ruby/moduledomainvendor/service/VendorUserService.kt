package ruby.moduledomainvendor.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ruby.moduledomainvendor.exception.VendorUserDuplicateException
import ruby.moduledomainvendor.request.VendorUserCreateRequest
import ruby.modulerds.entity.VendorUser
import ruby.modulerds.entity.VendorUserRole
import ruby.modulerds.entity.enbeddable.VendorUserRoleId
import ruby.modulerds.repository.VendorUserRepository
import ruby.modulerds.repository.VendorUserRoleRepository

@Service
class VendorUserService(
    private val vendorUserRepository: VendorUserRepository,
    private val vendorUserRoleRepository: VendorUserRoleRepository,
    private val passwordEncoder: PasswordEncoder
) {

    @Transactional
    fun createVendorUser(request: VendorUserCreateRequest) {
        if (checkDuplicateVendorUser(request.userId)) {
            throw VendorUserDuplicateException()
        }

        val saveVendorUser = vendorUserRepository.save(
            VendorUser(
                userId = request.userId,
                username = request.username,
                password = passwordEncoder.encode(request.password),
                vendor = request.vendor
            )
        )

        request.roles.forEach {
            val vendorUserRoleId = VendorUserRoleId(saveVendorUser.id, it)
            val vendorUserRole = VendorUserRole(vendorUserRoleId, saveVendorUser)
            vendorUserRoleRepository.save(vendorUserRole)
        }
    }

    private fun checkDuplicateVendorUser(userId: String) : Boolean {
        return vendorUserRepository.existsByUserId(userId)
    }
}