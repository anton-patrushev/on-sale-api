package com.onsale.onsaleapi.domains.categories.mappers

import com.onsale.onsaleapi.domains.categories.dto.CreateCategoryResponse
import com.onsale.onsaleapi.domains.categories.dto.CreateCategoryResponseData
import com.onsale.onsaleapi.domains.categories.entities.OfferCategory
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class CreateCategoryResponseMapper : IMapper<OfferCategory, CreateCategoryResponse> {
    override fun transform(source: OfferCategory): CreateCategoryResponse {
        return CreateCategoryResponse(
            data = CreateCategoryResponseData(source.id, source.name)
        )
    }
}