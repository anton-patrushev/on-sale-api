package com.onsale.onsaleapi.domains.offers.mappers

import com.onsale.onsaleapi.domains.offers.dto.GetOffersResponse
import com.onsale.onsaleapi.domains.offers.dto.GetOffersResponseRow
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCityInfo
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCompanyInfo
import com.onsale.onsaleapi.domains.offers.entities._Offer
import com.onsale.onsaleapi.domains.offers.mappers.common.OfferResponseMapperAdditionalParams
import com.onsale.onsaleapi.domains.shared.types.IMapperWithAdditionalParams
import org.springframework.stereotype.Component

@Component
class GetOffersResponseMapper :
    IMapperWithAdditionalParams<List<_Offer>, GetOffersResponse, List<OfferResponseMapperAdditionalParams>> {
    override fun transform(
        source: List<_Offer>,
        additionalParams: List<OfferResponseMapperAdditionalParams>
    ): GetOffersResponse {
        val offersWithAdditionalParams = source.zip(additionalParams)

        return GetOffersResponse(
            offersWithAdditionalParams.map {
                GetOffersResponseRow(
                    it.first.id,
                    CommonCompanyInfo(
                        it.second.company.id,
                        it.second.company.name,
                        it.second.company.websiteURL,
                        it.second.company.email,
                        it.second.company.phone,
                        it.second.company.workSchedule
                    ),
                    it.first.description,
                    it.first.sale,
                    CommonCityInfo(it.second.city.id, it.second.city.name),
                    it.first.createdAt.toString()
                )
            }
        )
    }


}