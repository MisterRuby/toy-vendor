package ruby.modulerds.entity

import jakarta.persistence.*
import ruby.modulerds.Auditable

@Entity
class VendorUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val userId: String,

    @Column(nullable = false)
    val username: String,

    @Column(nullable = false)
    val password: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    val vendor: Vendor,

    @OneToMany(mappedBy = "vendorUser", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val roles: List<VendorUserRole> = mutableListOf()
) : Auditable()