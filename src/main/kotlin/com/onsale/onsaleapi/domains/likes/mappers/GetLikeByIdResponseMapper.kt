package com.onsale.onsaleapi.domains.likes.mappers

import com.onsale.onsaleapi.domains.employees.mappers.GetEmployeeByIdResponseMapper
import com.onsale.onsaleapi.domains.likes.dto.GetLikeByIdResponse
import com.onsale.onsaleapi.domains.likes.dto.GetLikeByIdResponseData
import com.onsale.onsaleapi.domains.likes.entities.Like
import com.onsale.onsaleapi.domains.offers.mappers.GetOfferByIdResponseMapper
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class GetLikeByIdResponseMapper(
    @Autowired val getOfferByIdResponseMapper: GetOfferByIdResponseMapper,
    @Autowired val getEmployeeByIdResponseMapper: GetEmployeeByIdResponseMapper
) : IMapper<Like, GetLikeByIdResponse> {
    override fun transform(source: Like): GetLikeByIdResponse {
        return GetLikeByIdResponse(
            data = GetLikeByIdResponseData(
                source.id,
                offer = getOfferByIdResponseMapper.transform(source.offer).data,
                employee = getEmployeeByIdResponseMapper.transform(source.employee).data
            )
        )
    }

}