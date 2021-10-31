package com.onsale.onsaleapi.employees.dto

import com.onsale.onsaleapi.shared.types.ID

data class DeleteEmployeeByIdResponseData(val id: ID, val first_name: String, val last_name: String)
data class DeleteEmployeeByIdResponse(val data: DeleteEmployeeByIdResponseData)
