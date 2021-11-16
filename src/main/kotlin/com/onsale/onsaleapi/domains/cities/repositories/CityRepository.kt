package com.onsale.onsaleapi.domains.cities.repositories

import com.onsale.onsaleapi.domains.cities.entities.City
import com.onsale.onsaleapi.domains.cities.entities.CityFields
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.stereotype.Repository

@Repository
class CityRepository : ICityRepository {
    override fun create(city: City) {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<City> {
        TODO("Not yet implemented")
    }

    override fun getById(id: ID): City? {
        TODO("Not yet implemented")
    }

    override fun update(id: ID, fieldsToUpdate: CityFields) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: ID) {
        TODO("Not yet implemented")
    }
}