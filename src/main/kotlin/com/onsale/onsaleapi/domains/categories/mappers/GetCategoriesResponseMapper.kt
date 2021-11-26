package com.onsale.onsaleapi.domains.categories.mappers

import com.onsale.onsaleapi.domains.categories.dto.GetCategoriesResponse
import com.onsale.onsaleapi.domains.categories.dto.GetCategoriesResponseDataRow
import com.onsale.onsaleapi.domains.categories.entities.OfferCategory
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class GetCategoriesResponseMapper : IMapper<List<OfferCategory>, GetCategoriesResponse> {
    override fun transform(source: List<OfferCategory>): GetCategoriesResponse {
        return GetCategoriesResponse(
            data = source.map {
                GetCategoriesResponseDataRow(it.id, it.name)
            }
        )
    }
}