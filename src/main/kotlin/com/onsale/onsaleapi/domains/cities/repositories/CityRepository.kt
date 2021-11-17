package com.onsale.onsaleapi.domains.cities.repositories

import com.onsale.onsaleapi.domains.cities.db.CitiesTable
import com.onsale.onsaleapi.domains.cities.entities.City
import com.onsale.onsaleapi.domains.cities.entities.CityFields
import com.onsale.onsaleapi.domains.cities.entities.fromDBRow
import com.onsale.onsaleapi.domains.shared.types.ID
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class CityRepository : ICityRepository {
    override fun create(city: City) {
        transaction {
            CitiesTable.insert {
                it[id] = UUID.fromString(city.id)
                it[name] = city.name
            }
        }
    }

    override fun getAll(): List<City> {
        val cities = transaction {
            CitiesTable.selectAll()
        }

        return cities.map(City.Companion::fromDBRow)
    }

    override fun getById(id: ID): City? {
        val query = transaction {
            CitiesTable.select { CitiesTable.id eq UUID.fromString(id) }.firstOrNull()
        } ?: return null

        return query.let(City.Companion::fromDBRow)
    }

    override fun update(id: ID, fieldsToUpdate: CityFields) {
        transaction {
            CitiesTable.update({ CitiesTable.id eq UUID.fromString(id) }) {
                if (fieldsToUpdate.name != null) it[name] = fieldsToUpdate.name
            }
        }
    }

    override fun deleteAll() {
        transaction {
            CitiesTable.deleteAll()
        }
    }

    override fun deleteById(id: ID) {
        transaction {
            CitiesTable.deleteWhere { CitiesTable.id eq UUID.fromString(id) }
        }
    }
}