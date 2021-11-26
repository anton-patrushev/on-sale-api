package com.onsale.onsaleapi.domains.categories.mappers

import com.onsale.onsaleapi.domains.categories.dto.GetCategoryByIdResponse
import com.onsale.onsaleapi.domains.categories.dto.GetCategoryByIdResponseData
import com.onsale.onsaleapi.domains.categories.entities.OfferCategory
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class GetCategoryByIdResponseMapper : IMapper<OfferCategory, GetCategoryByIdResponse> {
    override fun transform(source: OfferCategory): GetCategoryByIdResponse {
        return GetCategoryByIdResponse(
            data = GetCategoryByIdResponseData(source.id, source.name)
        )
    }
}