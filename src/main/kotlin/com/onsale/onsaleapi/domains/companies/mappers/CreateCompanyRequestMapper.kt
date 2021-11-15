package com.onsale.onsaleapi.domains.companies.mappers

import com.onsale.onsaleapi.domains.companies.dto.CreateCompanyRequest
import com.onsale.onsaleapi.domains.companies.entities.Company
import com.onsale.onsaleapi.domains.shared.types.ID
import com.onsale.onsaleapi.domains.shared.types.IMapperWithAdditionalParams
import org.springframework.stereotype.Component

data class CreateCompanyRequestMapperAdditionalParams(val id: ID)

@Component
class CreateCompanyRequestMapper : IMapperWithAdditionalParams<CreateCompanyRequest, Company, CreateCompanyRequestMapperAdditionalParams> {
    override fun transform(source: CreateCompanyRequest, additionalParams: CreateCompanyRequestMapperAdditionalParams): Company {
        return Company(
                additionalParams.id,
                source.name,
                source.website_url,
                source.email,
                source.phone,
                source.work_schedule
        )
    }
}