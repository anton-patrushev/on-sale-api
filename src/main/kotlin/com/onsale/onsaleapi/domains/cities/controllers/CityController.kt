package com.onsale.onsaleapi.domains.cities.controllers

import com.onsale.onsaleapi.domains.cities.controllers.CityController.Companion.BASE_CITY_URL
import com.onsale.onsaleapi.domains.cities.dto.*
import com.onsale.onsaleapi.domains.cities.entities.City
import com.onsale.onsaleapi.domains.cities.mappers.*
import com.onsale.onsaleapi.domains.cities.services.CityService
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RequestMapping(value = [BASE_CITY_URL])
class CityController(
        @Autowired val cityService: CityService,
        @Autowired val createCityResponseMapper: CreateCityResponseMapper,
        @Autowired val getCityByIdResponseMapper: GetCityByIdResponseMapper,
        @Autowired val getCitiesResponseMapper: GetCitiesResponseMapper,
        @Autowired val deleteCityByIdResponseMapper: DeleteCityByIdResponseMapper,
        @Autowired val updateCityResponseMapper: UpdateCityResponseMapper
) : ICityController {
    @PostMapping
    override fun createCity(@RequestBody request: CreateCityRequest): ResponseEntity<CreateCityResponse> {
        val city = cityService.create(request)

        return ResponseEntity
                .created(URI.create(BASE_CITY_URL.plus("/${city.id}")))
                .body(createCityResponseMapper.transform(city))
    }

    @GetMapping("/{id}")
    override fun getCityById(@PathVariable id: ID): ResponseEntity<GetCityByIdResponse> {
        val city = cityService.getById(id)

        return when (city) {
            is City -> ResponseEntity.ok(getCityByIdResponseMapper.transform(city))
            else -> ResponseEntity.notFound().build()
        }
    }

    @GetMapping
    override fun getCities(): ResponseEntity<GetCitiesResponse> {
        val cities = cityService.getAll()

        return ResponseEntity.ok(getCitiesResponseMapper.transform(cities))
    }

    @DeleteMapping("/{id}")
    override fun deleteCityById(@PathVariable id: ID): ResponseEntity<DeleteCityByIdResponse> {
        val city = cityService.deleteById(id)

        return when (city) {
            is City -> ResponseEntity.ok(deleteCityByIdResponseMapper.transform(city))
            else -> ResponseEntity.notFound().build()
        }
    }

    @PatchMapping("/{id}")
    override fun updateCityById(@PathVariable id: ID, @RequestBody request: UpdateCityRequest): ResponseEntity<UpdateCityResponse> {
        val city = cityService.edit(id, request)

        return when (city) {
            is City -> ResponseEntity.ok(updateCityResponseMapper.transform(city))
            else -> ResponseEntity.notFound().build()
        }
    }

    companion object {
        const val BASE_CITY_URL = "cities/"
    }

}