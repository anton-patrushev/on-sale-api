package com.onsale.onsaleapi.domains.employees.entities

import com.onsale.onsaleapi.domains.employees.db.EmployeesTable
import com.onsale.onsaleapi.domains.shared.types.ID
import org.jetbrains.exposed.sql.ResultRow

data class Employee(val id: ID, val firstName: String, val lastName: String) {
    companion object {}
}

data class EmployeeFields(val firstName: String?, val lastName: String?)

// TODO: move into better place
fun Employee.Companion.fromDBRow(row: ResultRow): Employee {
    return Employee(
            row[EmployeesTable.id].toString(),
            row[EmployeesTable.firstName],
            row[EmployeesTable.lastName]
    )
}