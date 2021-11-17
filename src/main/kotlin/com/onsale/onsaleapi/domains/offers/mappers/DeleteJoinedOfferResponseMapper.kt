package com.onsale.onsaleapi.domains.offers.mappers

import com.onsale.onsaleapi.domains.offers.dto.DeleteOfferResponse
import com.onsale.onsaleapi.domains.offers.dto.DeleteOfferResponseData
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCityInfo
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCompanyInfo
import com.onsale.onsaleapi.domains.offers.entities.OfferJoined
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class DeleteJoinedOfferResponseMapper :
    IMapper<OfferJoined, DeleteOfferResponse> {
    override fun transform(source: OfferJoined): DeleteOfferResponse {
        return DeleteOfferResponse(
            DeleteOfferResponseData(
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