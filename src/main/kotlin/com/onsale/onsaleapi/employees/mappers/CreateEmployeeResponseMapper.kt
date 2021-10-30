package com.onsale.onsaleapi.employees.mappers

import com.onsale.onsaleapi.employees.dto.CreateEmployeeResponse
import com.onsale.onsaleapi.employees.dto.CreateEmployeeResponseData
import com.onsale.onsaleapi.employees.entities.Employee
import com.onsale.onsaleapi.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class CreateEmployeeResponseMapper: IMapper<Employee, CreateEmployeeResponse> {
    override fun transform(source: Employee): CreateEmployeeResponse {
        return CreateEmployeeResponse(data = CreateEmployeeResponseData(source.id, source.firstName, source.lastName))
    }
}