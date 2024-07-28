package ruby.modulerds.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ruby.modulerds.entity.VendorUser

@Repository
interface VendorUserRepository : JpaRepository<VendorUser, Long> {
    fun existsByUserId(userId: String): Boolean
}