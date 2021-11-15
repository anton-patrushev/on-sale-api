package com.onsale.onsaleapi.domains.companies.mappers

import com.onsale.onsaleapi.domains.companies.dto.UpdateCompanyRequest
import com.onsale.onsaleapi.domains.companies.entities.CompanyFields
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class UpdateCompanyRequestMapper: IMapper<UpdateCompanyRequest, CompanyFields> {
    override fun transform(source: UpdateCompanyRequest): CompanyFields {
        return CompanyFields(
                source.name,
                source.website_url,
                source.email,
                source.phone,
                source.work_schedule
        )
    }
}