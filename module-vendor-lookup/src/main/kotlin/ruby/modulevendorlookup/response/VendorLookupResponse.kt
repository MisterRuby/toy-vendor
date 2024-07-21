package ruby.modulevendorlookup.response

data class VendorLookupResponse(
    val request_cnt: Int,
    val status_code: String,
    val data: List<VendorLookupResult>
)

data class VendorLookupResult(
    val valid: String
)