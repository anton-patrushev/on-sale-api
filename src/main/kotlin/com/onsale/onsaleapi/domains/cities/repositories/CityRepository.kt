package com.onsale.onsaleapi.domains.cities.repositories

import com.onsale.onsaleapi.domains.cities.db.LikesTable
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
            LikesTable.insert {
                it[id] = UUID.fromString(city.id)
                it[name] = city.name
            }
        }
    }

    override fun getAll(): List<City> {
        val cities = transaction {
            LikesTable.selectAll().map { it }
        }

        return cities.map(City.Companion::fromDBRow)
    }

    override fun getById(id: ID): City? {
        val query = transaction {
            LikesTable.select { LikesTable.id eq UUID.fromString(id) }.firstOrNull()
        } ?: return null

        return query.let(City.Companion::fromDBRow)
    }

    override fun update(id: ID, fieldsToUpdate: CityFields) {
        transaction {
            LikesTable.update({ LikesTable.id eq UUID.fromString(id) }) {
                if (fieldsToUpdate.name != null) it[name] = fieldsToUpdate.name
            }
        }
    }

    override fun deleteAll() {
        transaction {
            LikesTable.deleteAll()
        }
    }

    override fun deleteById(id: ID) {
        transaction {
            LikesTable.deleteWhere { LikesTable.id eq UUID.fromString(id) }
        }
    }
}