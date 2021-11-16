package com.onsale.onsaleapi.domains.cities.mappers

import com.onsale.onsaleapi.domains.cities.dto.UpdateCityRequest
import com.onsale.onsaleapi.domains.cities.entities.CityFields
import com.onsale.onsaleapi.domains.shared.types.IMapper

class UpdateCityRequestMapper: IMapper<UpdateCityRequest, CityFields> {
    override fun transform(source: UpdateCityRequest): CityFields {
        return CityFields(source.name)
    }
}