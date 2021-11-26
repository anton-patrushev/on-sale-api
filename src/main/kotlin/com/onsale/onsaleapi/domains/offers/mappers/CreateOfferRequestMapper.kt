package com.onsale.onsaleapi.domains.offers.mappers

import com.onsale.onsaleapi.domains.offers.dto.CreateOfferRequest
import com.onsale.onsaleapi.domains.offers.entities.RawOffer
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class CreateOfferRequestMapper : IMapper<CreateOfferRequest, RawOffer> {
    override fun transform(source: CreateOfferRequest): RawOffer {
        return RawOffer(
            source.id,
            source.company_id,
            source.description,
            source.sale,
            source.city_id,
            LocalDate.parse(source.created_at)
        )
    }
}