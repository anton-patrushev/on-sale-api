package com.onsale.onsaleapi.employees.mappers

import com.onsale.onsaleapi.employees.dto.GetEmployeeByIdResponse
import com.onsale.onsaleapi.employees.dto.GetEmployeeByIdResponseData
import com.onsale.onsaleapi.employees.entities.Employee
import com.onsale.onsaleapi.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class GetEmployeeByIdResponseMapper: IMapper<Employee, GetEmployeeByIdResponse> {
    override fun transform(source: Employee): GetEmployeeByIdResponse {
        return GetEmployeeByIdResponse(data = GetEmployeeByIdResponseData(source.id, source.firstName, source.lastName))
    }
}