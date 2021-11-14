package com.onsale.onsaleapi.domains.employees.mappers

import com.onsale.onsaleapi.domains.employees.dto.UpdateEmployeeResponse
import com.onsale.onsaleapi.domains.employees.dto.UpdateEmployeeResponseData
import com.onsale.onsaleapi.domains.employees.entities.Employee
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class UpdateEmployeeResponseMapper: IMapper<Employee, UpdateEmployeeResponse> {
    override fun transform(source: Employee): UpdateEmployeeResponse {
        return UpdateEmployeeResponse(UpdateEmployeeResponseData(source.id, source.firstName, source.lastName))
    }
}