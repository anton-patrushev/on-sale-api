package com.onsale.onsaleapi.domains.employees.reporitories

import com.onsale.onsaleapi.domains.employees.db.EmployeesTable
import com.onsale.onsaleapi.domains.employees.entities.Employee
import com.onsale.onsaleapi.domains.employees.entities.EmployeeFields
import com.onsale.onsaleapi.domains.employees.entities.fromDBRow
import com.onsale.onsaleapi.domains.shared.types.ID
import org.jetbrains.exposed.sql.*
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

    override fun getAll(): List<Employee> {
        return transaction {
            EmployeesTable.selectAll().map(Employee::fromDBRow)
        }
    }

    override fun getById(id: ID): Employee? {
        val employee = transaction {
            EmployeesTable.select { EmployeesTable.id eq UUID.fromString(id) }.map(Employee::fromDBRow).getOrNull(0)
        }

        return employee
    }

    override fun update(id: ID, fieldsToUpdate: EmployeeFields): Employee {
        transaction {
            EmployeesTable.update({ EmployeesTable.id eq UUID.fromString(id) }) {
                if (fieldsToUpdate.firstName != null) it[firstName] = fieldsToUpdate.firstName
                if (fieldsToUpdate.lastName != null) it[lastName] = fieldsToUpdate.lastName
            }
        }

        return getById(id) as Employee
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