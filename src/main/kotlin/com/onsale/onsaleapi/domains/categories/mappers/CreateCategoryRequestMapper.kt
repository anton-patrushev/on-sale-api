package com.onsale.onsaleapi.domains.categories.mappers

import com.onsale.onsaleapi.domains.categories.dto.CreateCategoryRequest
import com.onsale.onsaleapi.domains.categories.entities.OfferCategory
import com.onsale.onsaleapi.domains.shared.types.ID
import com.onsale.onsaleapi.domains.shared.types.IMapperWithAdditionalParams
import org.springframework.stereotype.Component

data class CreateCategoryRequestAdditionalParams(val id: ID)

@Component
class CreateCategoryRequestMapper :
    IMapperWithAdditionalParams<CreateCategoryRequest, OfferCategory, CreateCategoryRequestAdditionalParams> {
    override fun transform(
        source: CreateCategoryRequest,
        additionalParams: CreateCategoryRequestAdditionalParams
    ): OfferCategory {
        return OfferCategory(additionalParams.id, source.name)
    }
}