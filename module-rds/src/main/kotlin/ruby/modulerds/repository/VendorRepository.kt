package ruby.modulerds.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ruby.modulerds.entity.Vendor

@Repository
interface VendorRepository : JpaRepository<Vendor, Long>