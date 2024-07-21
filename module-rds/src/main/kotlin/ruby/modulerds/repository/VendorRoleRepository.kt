package ruby.modulerds.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ruby.modulerds.entity.VendorRole
import ruby.modulerds.entity.enbeddable.VendorRoleId

@Repository
interface VendorRoleRepository : JpaRepository<VendorRole, VendorRoleId>