package com.onsale.onsaleapi.domains.cities.mappers

import com.onsale.onsaleapi.domains.cities.dto.DeleteCityByIdResponse
import com.onsale.onsaleapi.domains.cities.dto.DeleteCityByIdResponseData
import com.onsale.onsaleapi.domains.cities.entities.City
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class DeleteCityByIdResponseMapper: IMapper<City, DeleteCityByIdResponse> {
    override fun transform(source: City): DeleteCityByIdResponse {
        return DeleteCityByIdResponse(DeleteCityByIdResponseData(source.id, source.name))
    }
}