package com.onsale.onsaleapi.domains.categories.mappers

import com.onsale.onsaleapi.domains.categories.dto.UpdateCategoryRequest
import com.onsale.onsaleapi.domains.categories.entities.OfferCategoryFields
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class UpdateCategoryRequestMapper : IMapper<UpdateCategoryRequest, OfferCategoryFields> {
    override fun transform(source: UpdateCategoryRequest): OfferCategoryFields {
        return OfferCategoryFields(source.name)
    }
}