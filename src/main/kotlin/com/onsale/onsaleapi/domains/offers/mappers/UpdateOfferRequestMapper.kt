package com.onsale.onsaleapi.domains.offers.mappers

import com.onsale.onsaleapi.domains.offers.dto.UpdateOfferRequest
import com.onsale.onsaleapi.domains.offers.entities.OfferFields
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class UpdateOfferRequestMapper : IMapper<UpdateOfferRequest, OfferFields> {
    override fun transform(source: UpdateOfferRequest): OfferFields {
        return OfferFields(null, source.description, source.sale, source.city_id, source.created_at)
    }
}