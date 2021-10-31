package com.onsale.onsaleapi.employees.db

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import java.util.UUID

object EmployeesTable : Table() {
    val id: Column<UUID> = uuid("id").uniqueIndex()
    val firstName: Column<String> = varchar("first_name", 50)
    val lastName: Column<String> = varchar("last_name", 50)

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}