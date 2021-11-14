package com.onsale.onsaleapi.domains.employees.controllers

import com.onsale.onsaleapi.domains.employees.controllers.EmployeeController.Companion.BASE_EMPLOYEE_URL
import com.onsale.onsaleapi.domains.employees.dto.*
import com.onsale.onsaleapi.domains.employees.entities.Employee
import com.onsale.onsaleapi.domains.employees.mappers.*
import com.onsale.onsaleapi.domains.employees.services.IEmployeeService
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_EMPLOYEE_URL])
class EmployeeController(
        @Autowired private val employeeService: IEmployeeService,
        @Autowired private val createEmployeeResponseMapper: CreateEmployeeResponseMapper,
        @Autowired private val updateEmployeeResponseMapper: UpdateEmployeeResponseMapper,
        @Autowired private val getEmployeeByIdResponseMapper: GetEmployeeByIdResponseMapper,
        @Autowired private val getAllEmployeesResponseMapper: GetAllEmployeesResponseMapper,
        @Autowired private val deleteEmployeeByIdResponseMapper: DeleteEmployeeByIdResponseMapper
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

    @GetMapping
    override fun getAllEmployees(): ResponseEntity<GetAllEmployeesResponse> {
        val employees = employeeService.getAll()

        return ResponseEntity
                .accepted()
                .body(getAllEmployeesResponseMapper.transform(employees))
    }

    @DeleteMapping("/{id}")
    override fun deleteEmployeeById(@PathVariable id: ID): ResponseEntity<DeleteEmployeeByIdResponse> {
        val employee = employeeService.deleteById(id)

        return when (employee) {
            is Employee -> ResponseEntity.ok(deleteEmployeeByIdResponseMapper.transform(employee))
            else -> ResponseEntity.notFound().build()
        }
    }

    @PatchMapping("/{id}")
    override fun updateEmployeeById(@PathVariable id: ID, @RequestBody request: UpdateEmployeeRequest): ResponseEntity<UpdateEmployeeResponse> {
        val employee = employeeService.edit(id, request)

        return when (employee) {
            is Employee -> ResponseEntity.ok(updateEmployeeResponseMapper.transform(employee))
            else -> ResponseEntity.notFound().build()
        }
    }

    companion object {
        const val BASE_EMPLOYEE_URL = "employees/"
    }
}