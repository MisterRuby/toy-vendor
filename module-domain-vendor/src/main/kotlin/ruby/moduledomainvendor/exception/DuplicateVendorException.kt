package ruby.moduledomainvendor.exception

import ruby.modulecore.exception.CommonException

class DuplicateVendorException(
    override val status: Int = 409,
    override val message: String = "해당 사업자 번호는 이미 등록된 번호입니다."
) : CommonException(status, message)