package com.onsale.onsaleapi.domains.companies.dto

import com.onsale.onsaleapi.domains.shared.types.ID

data class DeleteCompanyByIdResponseData(
        val id: ID,
        val name: String,
        val website_url: String?,
        val email: String?,
        val phone: String?,
        val work_schedule: String?
)

data class DeleteCompanyByIdResponse(val data: DeleteCompanyByIdResponseData)
