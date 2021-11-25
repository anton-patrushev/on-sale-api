package com.onsale.onsaleapi.domains.likes.mappers

import com.onsale.onsaleapi.domains.employees.mappers.GetEmployeeByIdResponseMapper
import com.onsale.onsaleapi.domains.likes.dto.CreateLikeResponse
import com.onsale.onsaleapi.domains.likes.dto.CreateLikeResponseData
import com.onsale.onsaleapi.domains.likes.entities.Like
import com.onsale.onsaleapi.domains.offers.mappers.GetByIdJoinedOfferResponseMapper
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CreateLikeResponseMapper(
        @Autowired val getByIdJoinedOfferResponseMapper: GetByIdJoinedOfferResponseMapper,
        @Autowired val getEmployeeByIdResponseMapper: GetEmployeeByIdResponseMapper
) : IMapper<Like, CreateLikeResponse> {
    override fun transform(source: Like): CreateLikeResponse {
        return CreateLikeResponse(data = CreateLikeResponseData(
                source.id,
                offer = getByIdJoinedOfferResponseMapper.transform(source.offer).data,
                employee = getEmployeeByIdResponseMapper.transform(source.employee).data
        ))
    }

}