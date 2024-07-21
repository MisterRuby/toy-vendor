package ruby.modulevendorlookup.service

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ruby.modulevendorlookup.request.VendorLookup
import ruby.modulevendorlookup.request.VendorLookupRequest
import ruby.modulevendorlookup.response.VendorLookupResponse

@Service
class VendorLookupService(private val restTemplate: RestTemplate) {

    fun validateVendorLookup(vendorLookup: VendorLookup): Boolean {
        // TODO : 환경 변수로 분리
        val url = "https://api.odcloud.kr/api/nts-businessman/v1/validate?serviceKey=MOeHsEoeIibgvhAzCpjubmcTeTp2TZSR3eIRbtbLzPblmP6xfOFia5t/d6J8b/fD3tJv1TXPtzO2DFOD/NtokA==&returnType=json"

        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_JSON
        }

        val request = HttpEntity(VendorLookupRequest(mutableListOf(vendorLookup)), headers)

        val response = restTemplate.postForEntity(url, request, VendorLookupResponse::class.java)

        return response.body?.data?.get(0)?.valid == "01"
    }
}