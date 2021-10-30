package com.onsale.onsaleapi.employees.controllers

import com.onsale.onsaleapi.employees.dto.CreateEmployeeRequest
import com.onsale.onsaleapi.employees.dto.CreateEmployeeResponse
import org.springframework.http.ResponseEntity

interface IEmployeeController {
    fun createEmployee(request: CreateEmployeeRequest): ResponseEntity<CreateEmployeeResponse>
}