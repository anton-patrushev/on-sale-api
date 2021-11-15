package com.onsale.onsaleapi.domains.companies.mappers

import com.onsale.onsaleapi.domains.companies.dto.GetCompanyByIdResponse
import com.onsale.onsaleapi.domains.companies.dto.GetCompanyByIdResponseData
import com.onsale.onsaleapi.domains.companies.entities.Company
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class GetCompanyByIdResponseMapper : IMapper<Company, GetCompanyByIdResponse> {
    override fun transform(source: Company): GetCompanyByIdResponse {
        return GetCompanyByIdResponse(data = GetCompanyByIdResponseData(
                source.id,
                source.name,
                source.websiteURL,
                source.email,
                source.phone,
                source.workSchedule,
        ))
    }
}