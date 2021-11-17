package com.onsale.onsaleapi.domains.offers.db

import com.onsale.onsaleapi.domains.cities.db.CitiesTable
import com.onsale.onsaleapi.domains.companies.db.CompaniesTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date
import java.time.LocalDate
import java.util.*

object OffersTable : Table("Offers") {
    val id: Column<UUID> = uuid("id").uniqueIndex()
//    val companyId: Column<UUID> = reference("company_id", CompaniesTable.id)
    val description: Column<String?> = varchar("description", 50).nullable()
    val sale: Column<String?> = varchar("sale", 50).nullable()
//    val cityId: Column<UUID> = reference("city_id", CitiesTable.id)
//    val createdAt: Column<LocalDate> = date("created_at") // TODO: Date type

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}