package ruby.modulerds.entity

import jakarta.persistence.*
import jakarta.persistence.EnumType.*
import ruby.modulecore.code.VendorStatusCode
import ruby.modulerds.Auditable

@Entity
class Vendor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val vendorNumber: String,           // 사업자번호

    @Column(nullable = false)
    val vendorName: String,             // 사업자명

    @Column(nullable = false)
    val vendorStartDate: String,        // 개업일자

    @Column(nullable = false)
    val representative: String,         // 대표자 성명

    @Column(nullable = false)
    val address: String,                // 회사 주소

    @Column(nullable = false)
    @Enumerated(STRING)
    val status: VendorStatusCode,       // 업체 허용 상태

    @OneToMany(mappedBy = "vendor", fetch = FetchType.LAZY)
    val roles: List<VendorRole> = mutableListOf(),

    @OneToMany(mappedBy = "vendor", fetch = FetchType.LAZY)
    val users: List<VendorUser> = mutableListOf()
) : Auditable()