package com.onsale.onsaleapi.domains.cities.mappers

import com.onsale.onsaleapi.domains.cities.dto.CreateLikeRequest
import com.onsale.onsaleapi.domains.cities.entities.City
import com.onsale.onsaleapi.domains.shared.types.ID
import com.onsale.onsaleapi.domains.shared.types.IMapperWithAdditionalParams
import org.springframework.stereotype.Component

data class CreateCompanyRequestMapperAdditionalParams(val id: ID)

@Component
class CreateCityRequestMapper: IMapperWithAdditionalParams<CreateLikeRequest, City, CreateCompanyRequestMapperAdditionalParams> {
    override fun transform(source: CreateLikeRequest, additionalParams: CreateCompanyRequestMapperAdditionalParams): City {
        return City(additionalParams.id, source.name)
    }
}