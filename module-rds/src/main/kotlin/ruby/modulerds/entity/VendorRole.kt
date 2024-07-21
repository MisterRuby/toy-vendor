package ruby.modulerds.entity

import jakarta.persistence.*
import ruby.modulerds.entity.enbeddable.VendorRoleId

@Entity
class VendorRole(

    @EmbeddedId
    val id: VendorRoleId,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("vendorId")
    @JoinColumn(name = "vendor_id")
    val vendor: Vendor
)