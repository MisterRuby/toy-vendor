package ruby.modulevendorlookup.request

data class VendorLookupRequest(
    val businesses: List<VendorLookup>
)

data class VendorLookup(
    val b_no: String,
    val start_dt: String,
    val p_nm: String,
    val p_nm2: String = "",
    val b_nm: String = "",
    val corp_no: String = "",
    val b_type: String = "",
    val b_adr: String = "",
)

