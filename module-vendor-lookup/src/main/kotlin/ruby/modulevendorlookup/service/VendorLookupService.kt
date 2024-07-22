package ruby.modulevendorlookup.service

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ruby.modulevendorlookup.config.VendorLookupProperties
import ruby.modulevendorlookup.request.VendorLookup
import ruby.modulevendorlookup.request.VendorLookupRequest
import ruby.modulevendorlookup.response.VendorLookupResponse

@Service
class VendorLookupService(
    private val restTemplate: RestTemplate,
    private val vendorLookupProperties: VendorLookupProperties
) {

    fun validateVendorLookup(vendorLookup: VendorLookup): Boolean {
        // TODO : 환경 변수로 분리
        val requestUrl = with(vendorLookupProperties) { "$url?&serviceKey=$serviceKey&returnType=$returnType" }

        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_JSON
        }

        val request = HttpEntity(VendorLookupRequest(mutableListOf(vendorLookup)), headers)

        val response = restTemplate.postForEntity(requestUrl, request, VendorLookupResponse::class.java)

        return response.body?.data?.get(0)?.valid == "01"
    }
}