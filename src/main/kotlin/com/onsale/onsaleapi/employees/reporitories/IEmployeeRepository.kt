package com.onsale.onsaleapi.employees.reporitories

import com.onsale.onsaleapi.employees.entities.Employee
import com.onsale.onsaleapi.shared.types.ID

interface IEmployeeRepository {
    // TODO: pass user as param
    fun create(employee: Employee): Employee

    fun getAll(): Array<Employee>
    fun getById(id: ID): Employee?

    fun update(id: ID): Employee

    fun deleteAll()
    fun deleteById(id: ID)
}