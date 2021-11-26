package com.onsale.onsaleapi.domains.categories.mappers

import com.onsale.onsaleapi.domains.categories.dto.UpdateCategoryResponse
import com.onsale.onsaleapi.domains.categories.dto.UpdateCategoryResponseData
import com.onsale.onsaleapi.domains.categories.entities.OfferCategory
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class UpdateCategoryResponseMapper : IMapper<OfferCategory, UpdateCategoryResponse> {
    override fun transform(source: OfferCategory): UpdateCategoryResponse {
        return UpdateCategoryResponse(
            data = UpdateCategoryResponseData(source.id, source.name)
        )
    }
}