package com.onsale.onsaleapi.employees.controllers

import com.onsale.onsaleapi.employees.controllers.EmployeeController.Companion.BASE_EMPLOYEE_URL
import com.onsale.onsaleapi.employees.dto.CreateEmployeeRequest
import com.onsale.onsaleapi.employees.dto.CreateEmployeeResponse
import com.onsale.onsaleapi.employees.dto.GetEmployeeByIdResponse
import com.onsale.onsaleapi.employees.entities.Employee
import com.onsale.onsaleapi.employees.mappers.CreateEmployeeResponseMapper
import com.onsale.onsaleapi.employees.mappers.GetEmployeeByIdResponseMapper
import com.onsale.onsaleapi.employees.services.IEmployeeService
import com.onsale.onsaleapi.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_EMPLOYEE_URL])
class EmployeeController(
        @Autowired private val employeeService: IEmployeeService,
        @Autowired private val createEmployeeResponseMapper: CreateEmployeeResponseMapper,
        @Autowired private val getEmployeeByIdResponseMapper: GetEmployeeByIdResponseMapper
        ): IEmployeeController {

    @PostMapping
    override fun createEmployee(@RequestBody request: CreateEmployeeRequest): ResponseEntity<CreateEmployeeResponse> {
        val employee = employeeService.create(request)

        return ResponseEntity
                .created(URI.create(BASE_EMPLOYEE_URL.plus("/${employee.id}")))
                .body(createEmployeeResponseMapper.transform(employee))
    }

    @GetMapping("/{id}")
    override fun getEmployeeById(@PathVariable id: ID): ResponseEntity<GetEmployeeByIdResponse> {
        val employee = employeeService.getById(id)

        return when (employee) {
            is Employee -> ResponseEntity
                    .accepted()
                    .body(getEmployeeByIdResponseMapper.transform(employee))
            else -> ResponseEntity.notFound().build()
        }
    }

    companion object {
        const val BASE_EMPLOYEE_URL = "employees/"
    }
}