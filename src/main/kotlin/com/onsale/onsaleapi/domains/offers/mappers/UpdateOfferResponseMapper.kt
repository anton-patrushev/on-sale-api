package com.onsale.onsaleapi.domains.offers.mappers

import com.onsale.onsaleapi.domains.offers.dto.UpdateOfferResponse
import com.onsale.onsaleapi.domains.offers.dto.UpdateOfferResponseData
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCityInfo
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCompanyInfo
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.offers.mappers.common.OfferResponseMapperAdditionalParams
import com.onsale.onsaleapi.domains.shared.types.IMapperWithAdditionalParams

class UpdateOfferResponseMapper : IMapperWithAdditionalParams<Offer, UpdateOfferResponse, OfferResponseMapperAdditionalParams> {
    override fun transform(source: Offer, additionalParams: OfferResponseMapperAdditionalParams): UpdateOfferResponse {
        return UpdateOfferResponse(
                UpdateOfferResponseData(
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
                        source.created_at
                )
        )
    }

}