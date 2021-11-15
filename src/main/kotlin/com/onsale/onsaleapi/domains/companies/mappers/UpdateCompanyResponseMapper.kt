package com.onsale.onsaleapi.domains.companies.mappers

import com.onsale.onsaleapi.domains.companies.dto.UpdateCompanyResponse
import com.onsale.onsaleapi.domains.companies.dto.UpdateCompanyResponseData
import com.onsale.onsaleapi.domains.companies.entities.Company
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class UpdateCompanyResponseMapper : IMapper<Company, UpdateCompanyResponse> {
    override fun transform(source: Company): UpdateCompanyResponse {
        return UpdateCompanyResponse(
                UpdateCompanyResponseData(
                        source.id,
                        source.name,
                        source.websiteURL,
                        source.email,
                        source.phone,
                        source.workSchedule
                )
        )
    }
}