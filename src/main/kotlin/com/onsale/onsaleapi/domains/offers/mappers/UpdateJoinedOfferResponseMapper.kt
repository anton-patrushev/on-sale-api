package com.onsale.onsaleapi.domains.offers.mappers

import com.onsale.onsaleapi.domains.offers.dto.UpdateOfferResponse
import com.onsale.onsaleapi.domains.offers.dto.UpdateOfferResponseData
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCityInfo
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCompanyInfo
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class UpdateJoinedOfferResponseMapper :
    IMapper<Offer, UpdateOfferResponse> {
    override fun transform(source: Offer): UpdateOfferResponse {
        return UpdateOfferResponse(
            UpdateOfferResponseData(
                source.id,
                CommonCompanyInfo(
                    source.company.id,
                    source.company.name,
                    source.company.websiteURL,
                    source.company.email,
                    source.company.phone,
                    source.company.workSchedule
                ),
                source.description,
                source.sale,
                CommonCityInfo(source.city.id, source.city.name),
                source.createdAt.toString()
            )
        )
    }

}