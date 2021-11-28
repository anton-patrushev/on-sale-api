package com.onsale.onsaleapi.domains.offers.mappers

import com.onsale.onsaleapi.domains.offers.dto.CreateOfferRequest
import com.onsale.onsaleapi.domains.offers.entities.RawOffer
import com.onsale.onsaleapi.domains.shared.types.ID
import com.onsale.onsaleapi.domains.shared.types.IMapperWithAdditionalParams
import org.springframework.stereotype.Component
import java.time.LocalDate

data class CreateOfferRequestAdditionalParams(val id: ID)

@Component
class CreateOfferRequestMapper :
    IMapperWithAdditionalParams<CreateOfferRequest, RawOffer, CreateOfferRequestAdditionalParams> {
    override fun transform(source: CreateOfferRequest, additionalParams: CreateOfferRequestAdditionalParams): RawOffer {
        return RawOffer(
            additionalParams.id,
            source.company_id,
            source.description,
            source.sale,
            source.city_id,
            LocalDate.parse(source.created_at)
        )
    }
}