package com.onsale.onsaleapi.employees.services

import com.onsale.onsaleapi.employees.dto.CreateEmployeeRequest
import com.onsale.onsaleapi.employees.dto.UpdateEmployeeRequest
import com.onsale.onsaleapi.employees.entities.Employee
import com.onsale.onsaleapi.employees.mappers.CreateEmployeeRequestMapper
import com.onsale.onsaleapi.employees.mappers.CreateEmployeeRequestMapperAdditionalParams
import com.onsale.onsaleapi.employees.mappers.UpdateEmployeeRequestMapper
import com.onsale.onsaleapi.employees.reporitories.IEmployeeRepository
import com.onsale.onsaleapi.shared.services.IUUIDService
import com.onsale.onsaleapi.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeService(
        @Autowired private val employeeRepository: IEmployeeRepository,
        @Autowired private val createEmployeeRequestMapper: CreateEmployeeRequestMapper,
        @Autowired private val updateEmployeeRequestMapper: UpdateEmployeeRequestMapper,
        @Autowired private val uuidService: IUUIDService
        ): IEmployeeService {
    override fun create(request: CreateEmployeeRequest): Employee {
        val uuid = uuidService.getUUID()
        val additionalMapperParams = CreateEmployeeRequestMapperAdditionalParams(uuid)

        return employeeRepository.create(createEmployeeRequestMapper.transform(request, additionalMapperParams))
    }

    override fun edit(id:ID, request: UpdateEmployeeRequest): Employee {
        val employeeFieldsToUpdate = updateEmployeeRequestMapper.transform(request)

        return employeeRepository.update(id, employeeFieldsToUpdate)
    }

    override fun getById(id: ID): Employee? {
        return employeeRepository.getById(id)
    }

    override fun getAll(): List<Employee> {
        return employeeRepository.getAll()
    }

    override fun deleteById(id: ID): Employee? {
        val employee = employeeRepository.getById(id)
        employeeRepository.deleteById(id)

        return employee
    }

}