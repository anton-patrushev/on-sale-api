package com.onsale.onsaleapi.domains.employees.mappers

import com.onsale.onsaleapi.domains.employees.dto.GetEmployeeByIdResponse
import com.onsale.onsaleapi.domains.employees.dto.GetEmployeeByIdResponseData
import com.onsale.onsaleapi.domains.employees.entities.Employee
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class GetEmployeeByIdResponseMapper: IMapper<Employee, GetEmployeeByIdResponse> {
    override fun transform(source: Employee): GetEmployeeByIdResponse {
        return GetEmployeeByIdResponse(data = GetEmployeeByIdResponseData(source.id, source.firstName, source.lastName))
    }
}