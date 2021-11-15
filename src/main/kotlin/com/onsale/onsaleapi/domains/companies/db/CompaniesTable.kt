package com.onsale.onsaleapi.domains.companies.db

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import java.util.UUID

object CompaniesTable : Table("Companies") {
    val id: Column<UUID> = uuid("id").uniqueIndex()
    val name: Column<String> = varchar("null", 50)
    val websiteURL: Column<String?> = varchar("website_url", 50).nullable()
    val email: Column<String?> = varchar("email", 50).nullable()
    val phone: Column<String?> = varchar("phone", 50).nullable()
    val workSchedule: Column<String?> = varchar("work_schedule", 150).nullable()

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}