package ruby.moduledomainvendor.request

import ruby.modulecore.code.VendorUserRoleCode
import ruby.modulerds.entity.Vendor

data class VendorUserCreateRequest(
    val username: String,                   // 사용자 성명
    val userId: String,                     // 사용자 id
    val password: String,                   // 사용자 비밀번호
    val roles: List<VendorUserRoleCode>,    // 사용자 권한
    val vendor: Vendor                      // 소속 업체
)