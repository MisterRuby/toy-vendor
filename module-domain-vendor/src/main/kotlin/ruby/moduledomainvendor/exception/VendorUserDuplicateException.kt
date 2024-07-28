package ruby.moduledomainvendor.exception

import ruby.modulecore.exception.CommonException

class VendorUserDuplicateException(
    override val status: Int = 409,
    override val message: String = "해당 사용자 아이디는 이미 등록되어 있는 아이디입니다."
) : CommonException(status, message)