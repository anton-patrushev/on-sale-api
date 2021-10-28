package com.onsale.onsaleapi.employees.services

import com.onsale.onsaleapi.employees.dto.CreateEmployeeRequest
import com.onsale.onsaleapi.employees.dto.UpdateEmployeeRequest
import com.onsale.onsaleapi.employees.entities.Employee
import com.onsale.onsaleapi.employees.mappers.CreateEmployeeRequestMapper
import com.onsale.onsaleapi.employees.mappers.CreateEmployeeRequestMapperAdditionalParams
import com.onsale.onsaleapi.employees.reporitories.IEmployeeRepository
import com.onsale.onsaleapi.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeService(
        @Autowired private val employeeRepository: IEmployeeRepository,
        @Autowired private val createEmployeeRequestMapper: CreateEmployeeRequestMapper
        ): IEmployeeService {
    override fun create(request: CreateEmployeeRequest): Employee {
        // TODO: generate uuid
        val id = "temp-id-${request.firstName}-${request.lastName}"
        val additionalMapperParams = CreateEmployeeRequestMapperAdditionalParams(id)

        return employeeRepository.create(createEmployeeRequestMapper.transform(request, additionalMapperParams))
    }

    override fun edit(request: UpdateEmployeeRequest): Employee {
        TODO("Not yet implemented")
    }

    override fun getById(id: ID): Employee? {
        TODO("Not yet implemented")
    }

    override fun getAll(id: ID): Array<Employee> {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: ID) {
        TODO("Not yet implemented")
    }

}