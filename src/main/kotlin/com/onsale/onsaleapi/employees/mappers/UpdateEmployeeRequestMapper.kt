package com.onsale.onsaleapi.employees.mappers

import com.onsale.onsaleapi.employees.dto.UpdateEmployeeRequest
import com.onsale.onsaleapi.employees.entities.EmployeeFields
import com.onsale.onsaleapi.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class UpdateEmployeeRequestMapper: IMapper<UpdateEmployeeRequest, EmployeeFields> {
    override fun transform(source: UpdateEmployeeRequest): EmployeeFields {
        return EmployeeFields(source.first_name, source.last_name)
    }
}