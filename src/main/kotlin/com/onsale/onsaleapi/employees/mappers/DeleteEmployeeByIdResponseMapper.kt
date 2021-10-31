package com.onsale.onsaleapi.employees.mappers

import com.onsale.onsaleapi.employees.dto.DeleteEmployeeByIdResponse
import com.onsale.onsaleapi.employees.dto.DeleteEmployeeByIdResponseData
import com.onsale.onsaleapi.employees.entities.Employee
import com.onsale.onsaleapi.shared.types.IMapper
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