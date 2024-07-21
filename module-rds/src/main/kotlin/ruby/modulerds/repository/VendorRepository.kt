package ruby.modulerds.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import ruby.modulerds.entity.Vendor

@Repository
interface VendorRepository : JpaRepository<Vendor, Long> {
    fun findByVendorNumber(vendorNumber: String): Vendor?

    @Query("SELECT v FROM Vendor v JOIN FETCH v.roles")
    fun findAllWithRoles(): List<Vendor>
}