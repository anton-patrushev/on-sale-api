package com.onsale.onsaleapi.employees.services

import com.onsale.onsaleapi.employees.dto.CreateEmployeeRequest
import com.onsale.onsaleapi.employees.dto.UpdateEmployeeRequest
import com.onsale.onsaleapi.employees.entities.Employee
import com.onsale.onsaleapi.shared.types.ID

interface IEmployeeService {
    fun create(request: CreateEmployeeRequest): Employee
    fun edit(request: UpdateEmployeeRequest): Employee

    fun getById(id: ID): Employee?
    fun getAll(id: ID): Array<Employee>

    fun deleteById(id: ID)

}