package com.onsale.onsaleapi.domains.companies.mappers

import com.onsale.onsaleapi.domains.companies.dto.DeleteCompanyByIdResponse
import com.onsale.onsaleapi.domains.companies.dto.DeleteCompanyByIdResponseData
import com.onsale.onsaleapi.domains.companies.entities.Company
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class DeleteCompanyByIdResponseMapper : IMapper<Company, DeleteCompanyByIdResponse> {
    override fun transform(source: Company): DeleteCompanyByIdResponse {
        return DeleteCompanyByIdResponse(data = DeleteCompanyByIdResponseData(
                source.id,
                source.name,
                source.websiteURL,
                source.email,
                source.phone,
                source.workSchedule
        ))
    }
}