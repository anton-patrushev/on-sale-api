package com.onsale.onsaleapi.domains.offers.mappers

import com.onsale.onsaleapi.domains.offers.dto.CreateOfferRequest
import com.onsale.onsaleapi.domains.offers.entities._Offer
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class CreateOfferRequestMapper : IMapper<CreateOfferRequest, _Offer> {
    override fun transform(source: CreateOfferRequest): _Offer {
        return _Offer(
            source.id,
            source.company_id,
            source.description,
            source.sale,
            source.city_id,
            LocalDate.parse(source.created_at)
        )
    }
}