package com.onsale.onsaleapi.domains.offers.mappers

import com.onsale.onsaleapi.domains.categories.mappers.GetCategoryByIdResponseMapper
import com.onsale.onsaleapi.domains.offers.dto.GetOffersResponse
import com.onsale.onsaleapi.domains.offers.dto.GetOffersResponseRow
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCityInfo
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCompanyInfo
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class GetOffersResponseMapper(
    @Autowired val getCategoryByIdResponseMapper: GetCategoryByIdResponseMapper
) : IMapper<List<Offer>, GetOffersResponse> {
    override fun transform(source: List<Offer>): GetOffersResponse {
        return GetOffersResponse(
            source.map {
                GetOffersResponseRow(
                    it.id,
                    company = CommonCompanyInfo(
                        it.company.id,
                        it.company.name,
                        it.company.websiteURL,
                        it.company.email,
                        it.company.phone,
                        it.company.workSchedule
                    ),
                    it.description,
                    it.sale,
                    city = CommonCityInfo(it.city.id, it.city.name),
                    it.createdAt.toString(),
                    categories = it.categories?.map { category ->
                        getCategoryByIdResponseMapper.transform(category).data
                    }
                )
            }
        )
    }


}