package com.onsale.onsaleapi.domains.offers.dto.common

import com.onsale.onsaleapi.domains.shared.types.ID

data class CommonCompanyInfo(
        val id: ID,
        val name: String,
        val website_url: String?,
        val email: String?,
        val phone: String?,
        val work_schedule: String?
)