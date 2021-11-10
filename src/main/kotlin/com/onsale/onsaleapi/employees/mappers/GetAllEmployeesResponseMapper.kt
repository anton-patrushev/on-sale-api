package com.onsale.onsaleapi.employees.mappers

import com.onsale.onsaleapi.employees.dto.GetAllEmployeesResponse
import com.onsale.onsaleapi.employees.dto.GetAllEmployeesRow
import com.onsale.onsaleapi.employees.entities.Employee
import com.onsale.onsaleapi.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class GetAllEmployeesResponseMapper: IMapper<List<Employee>, GetAllEmployeesResponse> {
    override fun transform(source: List<Employee>): GetAllEmployeesResponse {
        return GetAllEmployeesResponse(data = source.map {
            GetAllEmployeesRow(it.id, it.firstName, it.lastName)
        })
    }
}