package com.onsale.onsaleapi.domains.categories.mappers

import com.onsale.onsaleapi.domains.categories.dto.DeleteCategoryResponse
import com.onsale.onsaleapi.domains.categories.dto.DeleteCategoryResponseData
import com.onsale.onsaleapi.domains.categories.entities.OfferCategory
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class DeleteCategoryResponseMapper : IMapper<OfferCategory, DeleteCategoryResponse> {
    override fun transform(source: OfferCategory): DeleteCategoryResponse {
        return DeleteCategoryResponse(
            data = DeleteCategoryResponseData(source.id, source.name)
        )
    }
}