package com.onsale.onsaleapi.domains.likes.mappers

import com.onsale.onsaleapi.domains.employees.mappers.GetEmployeeByIdResponseMapper
import com.onsale.onsaleapi.domains.likes.dto.GetLikesResponse
import com.onsale.onsaleapi.domains.likes.dto.GetLikesResponseRow
import com.onsale.onsaleapi.domains.likes.entities.Like
import com.onsale.onsaleapi.domains.offers.mappers.GetOfferByIdResponseMapper
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class GetLikesResponseMapper(
    @Autowired val getOfferByIdResponseMapper: GetOfferByIdResponseMapper,
    @Autowired val getEmployeeByIdResponseMapper: GetEmployeeByIdResponseMapper
) : IMapper<List<Like>, GetLikesResponse> {
    override fun transform(source: List<Like>): GetLikesResponse {
        return GetLikesResponse(
            data = source.map {
                GetLikesResponseRow(
                    it.id,
                    offer = getOfferByIdResponseMapper.transform(it.offer).data,
                    employee = getEmployeeByIdResponseMapper.transform(it.employee).data
                )
            }
        )
    }

}