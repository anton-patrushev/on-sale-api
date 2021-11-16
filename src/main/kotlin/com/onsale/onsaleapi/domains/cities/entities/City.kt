package com.onsale.onsaleapi.domains.cities.entities

import com.onsale.onsaleapi.domains.cities.db.CitiesTable
import com.onsale.onsaleapi.domains.shared.types.ID
import org.jetbrains.exposed.sql.ResultRow

data class City(val id: ID, val name: String) {
    companion object {}
}

data class CityFields(val name: String?)

fun City.Companion.fromDBRow(row: ResultRow):City {
    return City(
            row[CitiesTable.id].toString(),
            row[CitiesTable.name]
    )
}