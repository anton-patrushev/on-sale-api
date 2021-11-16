package com.onsale.onsaleapi.domains.cities.db

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import java.util.*

object CitiesTable :Table("Cities") {
    val id: Column<UUID> = uuid("id").uniqueIndex()
    val name: Column<String> = varchar("name", 50)

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}