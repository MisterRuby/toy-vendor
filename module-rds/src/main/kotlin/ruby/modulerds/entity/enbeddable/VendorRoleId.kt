package ruby.modulerds.entity.enbeddable

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import ruby.modulecore.code.VendorRoleCode
import java.io.Serializable

@Embeddable
class VendorRoleId(
    @Column(name = "vendor_id")
    val vendorId: Long = 0,

    @Enumerated(EnumType.STRING)
    val role: VendorRoleCode
) : Serializable