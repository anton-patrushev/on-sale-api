package com.onsale.onsaleapi.domains.offers.mappers

import com.onsale.onsaleapi.domains.categories.mappers.GetCategoryByIdResponseMapper
import com.onsale.onsaleapi.domains.offers.dto.UpdateOfferResponse
import com.onsale.onsaleapi.domains.offers.dto.UpdateOfferResponseData
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCityInfo
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCompanyInfo
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UpdateOfferResponseMapper(
    @Autowired val getCategoryByIdResponseMapper: GetCategoryByIdResponseMapper
) :
    IMapper<Offer, UpdateOfferResponse> {
    override fun transform(source: Offer): UpdateOfferResponse {
        return UpdateOfferResponse(
            UpdateOfferResponseData(
                source.id,
                company = CommonCompanyInfo(
                    source.company.id,
                    source.company.name,
                    source.company.websiteURL,
                    source.company.email,
                    source.company.phone,
                    source.company.workSchedule
                ),
                source.description,
                source.sale,
                city = CommonCityInfo(source.city.id, source.city.name),
                source.createdAt.toString(),
                categories = source.categories?.map { getCategoryByIdResponseMapper.transform(it).data }
            )
        )
    }

}