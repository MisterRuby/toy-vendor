package ruby.modulerds.entity.enbeddable

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import ruby.modulecore.code.VendorUserRoleCode
import java.io.Serializable

@Embeddable
class VendorUserRoleId(
    @Column(name = "vendor_user_id")
    val vendorUserId: Long = 0,

    @Enumerated(EnumType.STRING)
    val role: VendorUserRoleCode
) : Serializable