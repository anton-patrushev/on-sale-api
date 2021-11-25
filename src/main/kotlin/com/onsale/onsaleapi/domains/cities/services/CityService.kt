package com.onsale.onsaleapi.domains.cities.services

import com.onsale.onsaleapi.domains.cities.dto.CreateLikeRequest
import com.onsale.onsaleapi.domains.cities.dto.UpdateCityRequest
import com.onsale.onsaleapi.domains.cities.entities.City
import com.onsale.onsaleapi.domains.cities.mappers.CreateCityRequestMapper
import com.onsale.onsaleapi.domains.cities.mappers.CreateCompanyRequestMapperAdditionalParams
import com.onsale.onsaleapi.domains.cities.mappers.UpdateCityRequestMapper
import com.onsale.onsaleapi.domains.cities.repositories.CityRepository
import com.onsale.onsaleapi.domains.shared.services.UUIDService
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CityService(
        @Autowired val cityRepository: CityRepository,
        @Autowired val uuidService: UUIDService,
        @Autowired val createCityRequestMapper: CreateCityRequestMapper,
        @Autowired val updateCityRequestMapper: UpdateCityRequestMapper,
) : ICityService {
    override fun create(request: CreateLikeRequest): City {
        val id = uuidService.getUUID()

        val city = createCityRequestMapper.transform(request, CreateCompanyRequestMapperAdditionalParams(id))

        cityRepository.create(city)

        return city
    }

    override fun edit(id: ID, request: UpdateCityRequest): City? {
        val cityFields = updateCityRequestMapper.transform(request)

        cityRepository.update(id, cityFields)

        return cityRepository.getById(id)
    }

    override fun getById(id: ID): City? {
        return cityRepository.getById(id)
    }

    override fun getAll(): List<City> {
        return cityRepository.getAll()
    }

    override fun deleteById(id: ID): City? {
        val city = cityRepository.getById(id)

        cityRepository.deleteById(id)

        return city
    }

}