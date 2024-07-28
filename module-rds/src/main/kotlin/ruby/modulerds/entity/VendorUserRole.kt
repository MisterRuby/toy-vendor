package ruby.modulerds.entity

import jakarta.persistence.*
import ruby.modulerds.entity.enbeddable.VendorUserRoleId

@Entity
class VendorUserRole(

    @EmbeddedId
    val id: VendorUserRoleId,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("vendorUserId")
    @JoinColumn(name = "vendor_user_id")
    val vendorUser: VendorUser
)