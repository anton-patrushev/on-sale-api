package com.onsale.onsaleapi.employees.controllers

import com.onsale.onsaleapi.employees.controllers.EmployeeController.Companion.BASE_EMPLOYEE_URL
import com.onsale.onsaleapi.employees.dto.CreateEmployeeRequest
import com.onsale.onsaleapi.employees.dto.CreateEmployeeResponse
import com.onsale.onsaleapi.employees.mappers.CreateEmployeeResponseMapper
import com.onsale.onsaleapi.employees.services.IEmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping(value = [BASE_EMPLOYEE_URL])
class EmployeeController(
        @Autowired private val employeeService: IEmployeeService,
        @Autowired private val createEmployeeResponseMapper: CreateEmployeeResponseMapper
        ): IEmployeeController {

    @PostMapping
    override fun createEmployee(@RequestBody request: CreateEmployeeRequest): ResponseEntity<CreateEmployeeResponse> {
        val employee = employeeService.create(request)

        return ResponseEntity
                .created(URI.create(BASE_EMPLOYEE_URL.plus("/${employee.id}")))
                .body(createEmployeeResponseMapper.transform(employee))
    }

    companion object {
        const val BASE_EMPLOYEE_URL = "employees/"
    }
}