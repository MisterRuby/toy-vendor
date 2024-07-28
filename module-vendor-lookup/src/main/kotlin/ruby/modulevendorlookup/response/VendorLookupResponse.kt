package ruby.modulevendorlookup.response

data class VendorLookupResponse(
    val request_cnt: Int,
    val status_code: String,
    val match_cnt: Int
)