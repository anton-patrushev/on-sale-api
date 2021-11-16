package com.onsale.onsaleapi.domains.cities.mappers

import com.onsale.onsaleapi.domains.cities.dto.GetCitiesResponse
import com.onsale.onsaleapi.domains.cities.dto.GetCitiesResponseRow
import com.onsale.onsaleapi.domains.cities.entities.City
import com.onsale.onsaleapi.domains.shared.types.IMapper

class GetCitiesResponseMapper : IMapper<List<City>, GetCitiesResponse> {
    override fun transform(source: List<City>): GetCitiesResponse {
        return GetCitiesResponse(source.map {
            GetCitiesResponseRow(it.id, it.name)
        })
    }
}