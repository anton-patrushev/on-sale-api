package com.onsale.onsaleapi.domains.employees.services

import com.onsale.onsaleapi.domains.employees.dto.CreateEmployeeRequest
import com.onsale.onsaleapi.domains.employees.dto.UpdateEmployeeRequest
import com.onsale.onsaleapi.domains.employees.entities.Employee
import com.onsale.onsaleapi.domains.shared.types.ID

interface IEmployeeService {
    fun create(request: CreateEmployeeRequest): Employee
    fun edit(id: ID, request: UpdateEmployeeRequest): Employee?

    fun getById(id: ID): Employee?
    fun getAll(): List<Employee>

    fun deleteById(id: ID): Employee?

}