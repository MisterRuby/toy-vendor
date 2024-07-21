package ruby.moduledomainvendor.request

import ruby.modulecore.code.VendorRoleCode

data class VendorCreateRequest(
    val vendorNumber: String,           // 사업자번호
    val vendorName: String,             // 사업자명
    val vendorStartDate: String,        // 개업일자
    val representative: String,         // 대표자 성명
    val address: String,                // 회사 주소
    val type: String,                   // 사업자 종목
    val roles: List<VendorRoleCode>,    // 사업자 역할

    val masterUsername: String,         // 마스터 사용자 성명
    val masterUserId: String,           // 마스터 사용자 id
    val masterPassword: String,         // 마스터 사용자 비밀번호
)