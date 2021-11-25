package com.onsale.onsaleapi.domains.cities.entities

import com.onsale.onsaleapi.domains.cities.db.LikesTable
import com.onsale.onsaleapi.domains.shared.types.ID
import org.jetbrains.exposed.sql.ResultRow

data class City(val id: ID, val name: String) {
    companion object {}
}

data class CityFields(val name: String?)

fun City.Companion.fromDBRow(row: ResultRow):City {
    return City(
            row[LikesTable.id].toString(),
            row[LikesTable.name]
    )
}