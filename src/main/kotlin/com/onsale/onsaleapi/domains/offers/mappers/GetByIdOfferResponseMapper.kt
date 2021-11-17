package com.onsale.onsaleapi.domains.offers.mappers

import com.onsale.onsaleapi.domains.offers.dto.GetByIdOfferResponse
import com.onsale.onsaleapi.domains.offers.dto.GetByIdOfferResponseData
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCityInfo
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCompanyInfo
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.offers.mappers.common.OfferResponseMapperAdditionalParams
import com.onsale.onsaleapi.domains.shared.types.IMapperWithAdditionalParams
import org.springframework.stereotype.Component

@Component
class GetByIdOfferResponseMapper :
    IMapperWithAdditionalParams<Offer, GetByIdOfferResponse, OfferResponseMapperAdditionalParams> {
    override fun transform(source: Offer, additionalParams: OfferResponseMapperAdditionalParams): GetByIdOfferResponse {
        return GetByIdOfferResponse(
            GetByIdOfferResponseData(
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