package com.onsale.onsaleapi.employees.dto

import com.onsale.onsaleapi.shared.types.ID

data class CreateEmployeeResponseData(val id: ID, val firstName: String, val lastName: String)
data class CreateEmployeeResponse(val data: CreateEmployeeResponseData)
