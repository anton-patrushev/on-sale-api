package com.onsale.onsaleapi.domains.likes.mappers

import com.onsale.onsaleapi.domains.employees.mappers.GetEmployeeByIdResponseMapper
import com.onsale.onsaleapi.domains.likes.dto.DeleteLikeResponse
import com.onsale.onsaleapi.domains.likes.dto.DeleteLikeResponseData
import com.onsale.onsaleapi.domains.likes.entities.Like
import com.onsale.onsaleapi.domains.offers.mappers.GetOfferByIdResponseMapper
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DeleteLikeResponseMapper(
    @Autowired val getOfferByIdResponseMapper: GetOfferByIdResponseMapper,
    @Autowired val getEmployeeByIdResponseMapper: GetEmployeeByIdResponseMapper
) : IMapper<Like, DeleteLikeResponse> {
    override fun transform(source: Like): DeleteLikeResponse {
        return DeleteLikeResponse(
            data = DeleteLikeResponseData(
                source.id,
                offer = getOfferByIdResponseMapper.transform(source.offer).data,
                employee = getEmployeeByIdResponseMapper.transform(source.employee).data
            )
        )
    }

}