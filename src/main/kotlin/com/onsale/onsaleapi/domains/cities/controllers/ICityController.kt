package com.onsale.onsaleapi.domains.cities.controllers

import com.onsale.onsaleapi.domains.cities.dto.*
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.http.ResponseEntity

interface ICityController {
    fun createCity(request: CreateLikeRequest): ResponseEntity<CreateCityResponse>
    fun getCityById(id: ID): ResponseEntity<GetCityByIdResponse>
    fun getCities(): ResponseEntity<GetCitiesResponse>
    fun deleteCityById(id: ID): ResponseEntity<DeleteCityByIdResponse>
    fun updateCityById(id: ID, request: UpdateCityRequest): ResponseEntity<UpdateCityResponse>
}