package com.onsale.onsaleapi.domains.employees.mappers

import com.onsale.onsaleapi.domains.employees.dto.CreateEmployeeRequest
import com.onsale.onsaleapi.domains.employees.entities.Employee
import com.onsale.onsaleapi.domains.shared.types.ID
import com.onsale.onsaleapi.domains.shared.types.IMapperWithAdditionalParams
import org.springframework.stereotype.Component

data class CreateEmployeeRequestMapperAdditionalParams(val id: ID)

@Component
class CreateEmployeeRequestMapper: IMapperWithAdditionalParams<CreateEmployeeRequest, Employee, CreateEmployeeRequestMapperAdditionalParams> {
    override fun transform(source: CreateEmployeeRequest, additionalParams: CreateEmployeeRequestMapperAdditionalParams): Employee {
        return Employee(additionalParams.id, source.first_name, source.last_name)
    }
}