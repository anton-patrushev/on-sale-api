package com.onsale.onsaleapi.employees.reporitories

import com.onsale.onsaleapi.employees.db.EmployeesTable
import com.onsale.onsaleapi.employees.entities.Employee
import com.onsale.onsaleapi.employees.entities.fromDBRow
import com.onsale.onsaleapi.shared.types.ID
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class EmployeeRepository : IEmployeeRepository {
    override fun create(employee: Employee): Employee {

        transaction {
            EmployeesTable.insert {
                it[id] = UUID.fromString(employee.id)
                it[firstName] = employee.firstName
                it[lastName] = employee.lastName
            }
        }

        return employee;
    }

    override fun getAll(): Array<Employee> {
        TODO("Not yet implemented")
    }

    override fun getById(id: ID): Employee? {
        val employee = transaction {
            EmployeesTable.select { EmployeesTable.id eq UUID.fromString(id) }.map(Employee::fromDBRow).getOrNull(0)
        }

        return employee
    }

    override fun update(id: ID): Employee {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: ID) {
        transaction {
            EmployeesTable.deleteWhere { EmployeesTable.id eq UUID.fromString(id) }
        }
    }
}