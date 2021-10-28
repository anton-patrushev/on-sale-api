package com.onsale.onsaleapi.employees.mappers

import com.onsale.onsaleapi.employees.dto.CreateEmployeeRequest
import com.onsale.onsaleapi.employees.entities.Employee
import com.onsale.onsaleapi.shared.types.ID
import com.onsale.onsaleapi.shared.types.IMapperWithAdditionalParams
import org.springframework.stereotype.Component

data class CreateEmployeeRequestMapperAdditionalParams(val id: ID)

@Component
class CreateEmployeeRequestMapper: IMapperWithAdditionalParams<CreateEmployeeRequest, Employee, CreateEmployeeRequestMapperAdditionalParams> {
    override fun transform(source: CreateEmployeeRequest, additionalParams: CreateEmployeeRequestMapperAdditionalParams): Employee {
        return Employee(additionalParams.id, source.firstName, source.lastName)
    }
}