package com.onsale.onsaleapi.employees.controllers

import com.onsale.onsaleapi.employees.dto.CreateEmployeeRequest
import com.onsale.onsaleapi.employees.dto.CreateEmployeeResponse
import com.onsale.onsaleapi.employees.dto.GetEmployeeByIdResponse
import com.onsale.onsaleapi.shared.types.ID
import org.springframework.http.ResponseEntity

interface IEmployeeController {
    fun createEmployee(request: CreateEmployeeRequest): ResponseEntity<CreateEmployeeResponse>
    fun getEmployeeById(id: ID): ResponseEntity<GetEmployeeByIdResponse>
}