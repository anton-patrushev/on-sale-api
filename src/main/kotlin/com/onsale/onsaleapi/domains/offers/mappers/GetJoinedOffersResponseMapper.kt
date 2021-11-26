package com.onsale.onsaleapi.domains.offers.mappers

import com.onsale.onsaleapi.domains.offers.dto.GetOffersResponse
import com.onsale.onsaleapi.domains.offers.dto.GetOffersResponseRow
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCityInfo
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCompanyInfo
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class GetJoinedOffersResponseMapper : IMapper<List<Offer>, GetOffersResponse> {
    override fun transform(source: List<Offer>): GetOffersResponse {

        return GetOffersResponse(
            source.map {
                GetOffersResponseRow(
                    it.id,
                    CommonCompanyInfo(
                        it.company.id,
                        it.company.name,
                        it.company.websiteURL,
                        it.company.email,
                        it.company.phone,
                        it.company.workSchedule
                    ),
                    it.description,
                    it.sale,
                    CommonCityInfo(it.city.id, it.city.name),
                    it.createdAt.toString()
                )
            }
        )
    }


}