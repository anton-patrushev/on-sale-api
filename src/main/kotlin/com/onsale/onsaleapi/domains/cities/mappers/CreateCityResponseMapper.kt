package com.onsale.onsaleapi.domains.cities.mappers

import com.onsale.onsaleapi.domains.cities.dto.CreateCityResponse
import com.onsale.onsaleapi.domains.cities.dto.CreateCityResponseData
import com.onsale.onsaleapi.domains.cities.entities.City
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class CreateCityResponseMapper: IMapper<City, CreateCityResponse> {
    override fun transform(source: City): CreateCityResponse {
        return CreateCityResponse(CreateCityResponseData(source.id, source.name))
    }
}