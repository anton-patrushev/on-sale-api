package com.onsale.onsaleapi.domains.likes.db

import com.onsale.onsaleapi.domains.employees.db.EmployeesTable
import com.onsale.onsaleapi.domains.offers.db.OffersTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import java.util.*

object LikesTable : Table("Likes") {
    val id: Column<UUID> = uuid("id").uniqueIndex()
    val offerId: Column<UUID> = reference("offer_id", OffersTable.id)
    val employeeId: Column<UUID> = reference("employee_id", EmployeesTable.id)

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}