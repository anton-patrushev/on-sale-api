package com.onsale.onsaleapi.domains.cities.repositories

import com.onsale.onsaleapi.domains.cities.entities.City
import com.onsale.onsaleapi.domains.cities.entities.CityFields
import com.onsale.onsaleapi.domains.shared.types.ID

interface ICityRepository {
    fun create(city: City)

    fun getAll(): List<City>
    fun getById(id: ID): City?

    fun update(id: ID, fieldsToUpdate: CityFields)

    fun deleteAll()
    fun deleteById(id: ID)
}