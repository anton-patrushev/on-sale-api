package com.onsale.onsaleapi.domains.offers.mappers

import com.onsale.onsaleapi.domains.offers.dto.CreateOfferResponse
import com.onsale.onsaleapi.domains.offers.dto.CreateOfferResponseData
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCityInfo
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCompanyInfo
import com.onsale.onsaleapi.domains.offers.entities._Offer
import com.onsale.onsaleapi.domains.offers.mappers.common.OfferResponseMapperAdditionalParams
import com.onsale.onsaleapi.domains.shared.types.IMapperWithAdditionalParams
import org.springframework.stereotype.Component

@Component
class CreateOfferResponseMapper :
    IMapperWithAdditionalParams<_Offer, CreateOfferResponse, OfferResponseMapperAdditionalParams> {
    override fun transform(source: _Offer, additionalParams: OfferResponseMapperAdditionalParams): CreateOfferResponse {
        return CreateOfferResponse(
            CreateOfferResponseData(
                source.id,
                CommonCompanyInfo(
                    additionalParams.company.id,
                    additionalParams.company.name,
                    additionalParams.company.websiteURL,
                    additionalParams.company.email,
                    additionalParams.company.phone,
                    additionalParams.company.workSchedule
                ),
                source.description,
                source.sale,
                CommonCityInfo(additionalParams.city.id, additionalParams.city.name),
                source.createdAt.toString()
            )
        )
    }

}