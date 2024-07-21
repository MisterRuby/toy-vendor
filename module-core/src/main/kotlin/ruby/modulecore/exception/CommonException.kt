package ruby.modulecore.exception

open class CommonException (
    open val status: Int,
    override val message: String
) : RuntimeException(message)