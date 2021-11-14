package com.onsale.onsaleapi.employees.dto

import com.onsale.onsaleapi.shared.types.ID

data class UpdateEmployeeResponseData(val id: ID, val first_name: String, val last_name: String)
data class UpdateEmployeeResponse(val data: UpdateEmployeeResponseData)
