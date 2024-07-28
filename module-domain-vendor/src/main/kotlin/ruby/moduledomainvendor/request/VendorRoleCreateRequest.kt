package ruby.moduledomainvendor.request

import ruby.modulecore.code.VendorRoleCode
import ruby.modulerds.entity.Vendor

data class VendorRoleCreateRequest(
    val vendor: Vendor,
    val role: VendorRoleCode
)