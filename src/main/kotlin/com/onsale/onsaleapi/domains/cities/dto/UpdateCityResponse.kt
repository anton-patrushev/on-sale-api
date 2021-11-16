package com.onsale.onsaleapi.domains.cities.dto

import com.onsale.onsaleapi.domains.shared.types.ID

data class UpdateCityResponseData(val id: ID, val name: String)
data class UpdateCityResponse(val data: UpdateCityResponseData)