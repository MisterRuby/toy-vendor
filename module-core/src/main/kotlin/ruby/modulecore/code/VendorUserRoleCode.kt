package ruby.modulecore.code

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class VendorUserRoleCode(private val code: String) {
    MASTER("MASTER"),               // 관리자
    ADVERTISER("ADVERTISER"),       // 광고주
    MEDIA("MEDIA"),                 // 매체사
    SALES("SALES");                 // 영업사

    @JsonValue
    override fun toString(): String {
        return code
    }

    companion object {
        @JvmStatic
        @JsonCreator
        fun fromValue(value: String): VendorUserRoleCode {
            return values().find { it.code == value } ?: throw IllegalArgumentException("Unknown role: $value")
        }
    }
}