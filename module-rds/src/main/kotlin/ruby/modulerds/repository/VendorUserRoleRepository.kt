package ruby.modulerds.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ruby.modulerds.entity.VendorUserRole
import ruby.modulerds.entity.enbeddable.VendorUserRoleId

@Repository
interface VendorUserRoleRepository : JpaRepository<VendorUserRole, VendorUserRoleId>