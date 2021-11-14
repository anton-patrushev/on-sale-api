package com.onsale.onsaleapi.domains.employees.mappers

import com.onsale.onsaleapi.domains.employees.dto.DeleteEmployeeByIdResponse
import com.onsale.onsaleapi.domains.employees.dto.DeleteEmployeeByIdResponseData
import com.onsale.onsaleapi.domains.employees.entities.Employee
import com.onsale.onsaleapi.domains.shared.types.IMapper
import org.springframework.stereotype.Component

@Component
class DeleteEmployeeByIdResponseMapper : IMapper<Employee, DeleteEmployeeByIdResponse> {
    override fun transform(source: Employee): DeleteEmployeeByIdResponse {
        return DeleteEmployeeByIdResponse(data = DeleteEmployeeByIdResponseData(
                source.id,
                source.firstName,
                source.lastName
        ))
    }
}