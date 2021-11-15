package com.onsale.onsaleapi.domains.companies.mappers

import com.onsale.onsaleapi.domains.companies.dto.GetAllCompaniesResponse
import com.onsale.onsaleapi.domains.companies.dto.GetAllCompaniesRow
import com.onsale.onsaleapi.domains.companies.entities.Company
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class GetAllCompaniesResponseMapper: IMapper<List<Company>, GetAllCompaniesResponse> {
    override fun transform(source: List<Company>): GetAllCompaniesResponse {
        return GetAllCompaniesResponse(data = source.map {
            GetAllCompaniesRow(
                    it.id,
                    it.name,
                    it.websiteURL,
                    it.email,
                    it.phone,
                    it.workSchedule,
            )
        })
    }
}