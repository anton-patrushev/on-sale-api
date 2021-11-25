package com.onsale.onsaleapi.domains.likes.mappers

import com.onsale.onsaleapi.domains.likes.dto.CreateLikeRequest
import com.onsale.onsaleapi.domains.likes.entities.RawLike
import com.onsale.onsaleapi.domains.shared.types.ID
import com.onsale.onsaleapi.domains.shared.types.IMapperWithAdditionalParams
import org.springframework.stereotype.Component

data class CreateLikeRequestMapperAdditionalParams(val id: ID)

@Component
class CreateLikeRequestMapper :
    IMapperWithAdditionalParams<CreateLikeRequest, RawLike, CreateLikeRequestMapperAdditionalParams> {
    override fun transform(
        source: CreateLikeRequest,
        additionalParams: CreateLikeRequestMapperAdditionalParams
    ): RawLike {
        return RawLike(additionalParams.id, source.offer_id, source.employee_id)
    }
}