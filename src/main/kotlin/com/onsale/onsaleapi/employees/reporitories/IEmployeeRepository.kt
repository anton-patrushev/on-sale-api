package com.onsale.onsaleapi.employees.reporitories

import com.onsale.onsaleapi.employees.entities.Employee
import com.onsale.onsaleapi.employees.entities.EmployeeFields
import com.onsale.onsaleapi.shared.types.ID

interface IEmployeeRepository {
    fun create(employee: Employee): Employee

    fun getAll(): List<Employee>
    fun getById(id: ID): Employee?

    fun update(id: ID, fieldsToUpdate: EmployeeFields): Employee

    fun deleteAll()
    fun deleteById(id: ID)
}