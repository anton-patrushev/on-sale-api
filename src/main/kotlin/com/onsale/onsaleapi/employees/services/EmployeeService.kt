package com.onsale.onsaleapi.employees.services

import com.onsale.onsaleapi.employees.dto.CreateEmployeeRequest
import com.onsale.onsaleapi.employees.dto.UpdateEmployeeRequest
import com.onsale.onsaleapi.employees.entities.Employee
import com.onsale.onsaleapi.employees.mappers.CreateEmployeeRequestMapper
import com.onsale.onsaleapi.employees.mappers.CreateEmployeeRequestMapperAdditionalParams
import com.onsale.onsaleapi.employees.reporitories.IEmployeeRepository
import com.onsale.onsaleapi.shared.services.IUUIDService
import com.onsale.onsaleapi.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class EmployeeService(
        @Autowired private val employeeRepository: IEmployeeRepository,
        @Autowired private val createEmployeeRequestMapper: CreateEmployeeRequestMapper,
        @Autowired private val uuidService: IUUIDService
        ): IEmployeeService {
    override fun create(request: CreateEmployeeRequest): Employee {
        val uuid = uuidService.getUUID()
        val additionalMapperParams = CreateEmployeeRequestMapperAdditionalParams(uuid)

        return employeeRepository.create(createEmployeeRequestMapper.transform(request, additionalMapperParams))
    }

    override fun edit(request: UpdateEmployeeRequest): Employee {
        TODO("Not yet implemented")
    }

    override fun getById(id: ID): Employee? {
        return employeeRepository.getById(id)
    }

    override fun getAll(id: ID): Array<Employee> {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: ID) {
        TODO("Not yet implemented")
    }

}