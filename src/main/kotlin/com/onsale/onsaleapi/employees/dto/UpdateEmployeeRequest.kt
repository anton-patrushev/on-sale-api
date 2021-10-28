package com.onsale.onsaleapi.employees.dto

import com.onsale.onsaleapi.shared.types.ID

data class UpdateEmployeeRequest(val id: ID, val firstName: String?, val lastName: String?)
