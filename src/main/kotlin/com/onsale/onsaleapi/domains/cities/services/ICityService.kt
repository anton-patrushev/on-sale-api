package com.onsale.onsaleapi.domains.cities.services

import com.onsale.onsaleapi.domains.cities.dto.CreateCityRequest
import com.onsale.onsaleapi.domains.cities.dto.UpdateCityRequest
import com.onsale.onsaleapi.domains.cities.entities.City
import com.onsale.onsaleapi.domains.shared.types.ID

interface ICityService {
    fun create(request: CreateCityRequest): City
    fun edit(id: ID, request: UpdateCityRequest): City?

    fun getById(id: ID): City?
    fun getAll(): List<City>

    fun deleteById(id: ID): City?
}