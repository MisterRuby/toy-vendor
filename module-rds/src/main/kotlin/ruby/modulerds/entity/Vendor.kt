package ruby.modulerds.entity

import jakarta.persistence.*
import ruby.modulerds.Auditable

@Entity
class Vendor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val vendorNumber: String,           // 사업자번호

    @Column(nullable = false)
    val vendorName: String,             // 사업자명

    @Column(nullable = false)
    val vendorStartDate: String,        // 개업일자

    @Column(nullable = false)
    val representative: String,         // 대표자 성명

    @Column(nullable = false)
    val address: String,                // 회사 주소

    @OneToMany(mappedBy = "vendor", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val roles: List<VendorRole> = mutableListOf()
) : Auditable()