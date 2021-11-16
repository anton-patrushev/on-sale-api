package com.onsale.onsaleapi.domains.cities.mappers

import com.onsale.onsaleapi.domains.cities.dto.GetCityByIdResponse
import com.onsale.onsaleapi.domains.cities.dto.GetCityByIdResponseData
import com.onsale.onsaleapi.domains.cities.entities.City
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class GetCityByIdResponseMapper: IMapper<City, GetCityByIdResponse> {
    override fun transform(source: City): GetCityByIdResponse {
        return GetCityByIdResponse(GetCityByIdResponseData(source.id, source.name))
    }
}