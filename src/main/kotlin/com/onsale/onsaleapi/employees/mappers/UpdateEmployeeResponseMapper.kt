package com.onsale.onsaleapi.employees.mappers

import com.onsale.onsaleapi.employees.dto.UpdateEmployeeResponse
import com.onsale.onsaleapi.employees.dto.UpdateEmployeeResponseData
import com.onsale.onsaleapi.employees.entities.Employee
import com.onsale.onsaleapi.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class UpdateEmployeeResponseMapper: IMapper<Employee, UpdateEmployeeResponse> {
    override fun transform(source: Employee): UpdateEmployeeResponse {
        return UpdateEmployeeResponse(UpdateEmployeeResponseData(source.id, source.firstName, source.lastName))
    }
}