package com.onsale.onsaleapi.domains.cities.controllers

import com.onsale.onsaleapi.domains.cities.dto.*
import com.onsale.onsaleapi.domains.likes.dto.CreateLikeRequest
import com.onsale.onsaleapi.domains.likes.dto.CreateLikeResponse
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.http.ResponseEntity

interface ILikeController {
    fun createLike(request: CreateLikeRequest): ResponseEntity<CreateLikeResponse>
//    fun getCityById(id: ID): ResponseEntity<GetCityByIdResponse>
//    fun getCities(): ResponseEntity<GetCitiesResponse>
//    fun deleteCityById(id: ID): ResponseEntity<DeleteCityByIdResponse>
//    fun updateCityById(id: ID, request: UpdateCityRequest): ResponseEntity<UpdateCityResponse>
}