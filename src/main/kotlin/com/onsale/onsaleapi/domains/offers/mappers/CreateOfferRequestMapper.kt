package com.onsale.onsaleapi.domains.offers.mappers

import com.onsale.onsaleapi.domains.offers.dto.CreateOfferRequest
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class CreateOfferRequestMapper : IMapper<CreateOfferRequest, Offer> {
    override fun transform(source: CreateOfferRequest): Offer {
        return Offer(
            source.id,
            source.company_id,
            source.description,
            source.sale,
            source.city_id,
            LocalDate.parse(source.created_at)
        )
    }
}