package com.onsale.onsaleapi.domains.companies.mappers

import com.onsale.onsaleapi.domains.companies.dto.CreateCompanyResponse
import com.onsale.onsaleapi.domains.companies.dto.CreateCompanyResponseData
import com.onsale.onsaleapi.domains.companies.entities.Company
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class CreateCompanyResponseMapper : IMapper<Company, CreateCompanyResponse> {
    override fun transform(source: Company): CreateCompanyResponse {
        return CreateCompanyResponse(data = CreateCompanyResponseData(
                source.id,
                source.name,
                source.websiteURL,
                source.email,
                source.phone,
                source.workSchedule
        ))
    }
}