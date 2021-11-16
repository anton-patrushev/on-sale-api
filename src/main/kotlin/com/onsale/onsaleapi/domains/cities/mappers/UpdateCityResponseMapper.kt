package com.onsale.onsaleapi.domains.cities.mappers

import com.onsale.onsaleapi.domains.cities.dto.UpdateCityResponse
import com.onsale.onsaleapi.domains.cities.dto.UpdateCityResponseData
import com.onsale.onsaleapi.domains.cities.entities.City
import com.onsale.onsaleapi.domains.shared.types.IMapper

class UpdateCityResponseMapper: IMapper<City, UpdateCityResponse> {
    override fun transform(source: City): UpdateCityResponse {
        return UpdateCityResponse(UpdateCityResponseData(source.id, source.name))
    }
}