package com.onsale.onsaleapi.domains.employees.mappers

import com.onsale.onsaleapi.domains.employees.dto.UpdateEmployeeRequest
import com.onsale.onsaleapi.domains.employees.entities.EmployeeFields
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class UpdateEmployeeRequestMapper: IMapper<UpdateEmployeeRequest, EmployeeFields> {
    override fun transform(source: UpdateEmployeeRequest): EmployeeFields {
        return EmployeeFields(source.first_name, source.last_name)
    }
}