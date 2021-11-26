package com.onsale.onsaleapi.domains.categories.db

import com.onsale.onsaleapi.domains.cities.db.CitiesTable.uniqueIndex
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import java.util.*

object CategoriesTable : Table("Categories") {
    val id: Column<UUID> = uuid("id").uniqueIndex()
    val name: Column<String> = varchar("name", 20).uniqueIndex()

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}