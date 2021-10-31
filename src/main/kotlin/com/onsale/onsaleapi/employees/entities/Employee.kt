package com.onsale.onsaleapi.employees.entities

import com.onsale.onsaleapi.employees.db.EmployeesTable
import com.onsale.onsaleapi.shared.types.ID
import org.jetbrains.exposed.sql.ResultRow

data class Employee(val id: ID, val firstName: String, val lastName: String) {
    companion object {}
}

// TODO: move into better place
fun Employee.Companion.fromDBRow(row: ResultRow): Employee {
    return Employee(
            row[EmployeesTable.id].toString(),
            row[EmployeesTable.firstName],
            row[EmployeesTable.lastName]
    )
}