package com.onsale.onsaleapi.domains.offers.dto

import com.onsale.onsaleapi.domains.offers.dto.common.CommonCityInfo
import com.onsale.onsaleapi.domains.offers.dto.common.CommonCompanyInfo
import com.onsale.onsaleapi.domains.shared.types.ID

data class UpdateOfferResponseData (
        val id: ID,
        val company: CommonCompanyInfo,
        val description: String?,
        val sale: String?,
        val city: CommonCityInfo,
        val created_at: String?
)

data class UpdateOfferResponse(val data: UpdateOfferResponseData)