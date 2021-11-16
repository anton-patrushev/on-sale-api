package com.onsale.onsaleapi.domains.cities.services

import com.onsale.onsaleapi.domains.cities.dto.CreateCityRequest
import com.onsale.onsaleapi.domains.cities.dto.UpdateCityRequest
import com.onsale.onsaleapi.domains.cities.entities.City
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.stereotype.Service

@Service
class CityService(

) : ICityService {
    override fun create(request: CreateCityRequest): City {
        TODO("Not yet implemented")
    }

    override fun edit(id: ID, request: UpdateCityRequest): City? {
        TODO("Not yet implemented")
    }

    override fun getById(id: ID): City? {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<City> {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: ID): City? {
        TODO("Not yet implemented")
    }

}