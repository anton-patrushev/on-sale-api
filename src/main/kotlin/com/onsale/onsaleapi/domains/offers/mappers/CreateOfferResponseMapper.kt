package com.onsale.onsaleapi.domains.offers.mappers

import com.onsale.onsaleapi.domains.offers.dto.CreateOfferResponse
import com.onsale.onsaleapi.domains.offers.dto.CreateOfferResponseData
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCityInfo
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCompanyInfo
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class CreateOfferResponseMapper :
    IMapper<Offer, CreateOfferResponse> {
    override fun transform(source: Offer): CreateOfferResponse {
        return CreateOfferResponse(
            CreateOfferResponseData(
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