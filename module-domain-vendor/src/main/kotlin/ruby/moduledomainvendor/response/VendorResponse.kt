package ruby.moduledomainvendor.response

data class VendorResponse(
    val id: Long,                       // 사업자 일련번호
    val vendorNumber: String,           // 사업자번호
    val vendorName: String,             // 사업자명
    val vendorStartDate: String,        // 개업일자
    val representative: String,         // 대표자 성명
    val address: String,                // 회사 주소
    val roles: List<String>,            // 사업자 역할
)