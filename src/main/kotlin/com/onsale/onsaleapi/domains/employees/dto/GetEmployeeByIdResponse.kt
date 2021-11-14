package com.onsale.onsaleapi.domains.employees.dto

import com.onsale.onsaleapi.domains.shared.types.ID

data class GetEmployeeByIdResponseData(val id: ID, val first_name: String, val last_name: String)
data class GetEmployeeByIdResponse(val data: GetEmployeeByIdResponseData)