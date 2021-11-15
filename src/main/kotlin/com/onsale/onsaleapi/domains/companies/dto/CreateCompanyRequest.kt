package com.onsale.onsaleapi.domains.companies.dto

data class CreateCompanyRequest(
        val name: String,
        val website_url: String?,
        val email: String?,
        val phone: String?,
        val work_schedule: String?
)
