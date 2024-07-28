package ruby.moduledomainvendor.exception

import ruby.modulecore.exception.CommonException

class VendorVerificationException(
    override val status: Int = 404,
    override val message: String = "해당 사업자 번호는 확인되지 않은 번호입니다."
) : CommonException(status, message)