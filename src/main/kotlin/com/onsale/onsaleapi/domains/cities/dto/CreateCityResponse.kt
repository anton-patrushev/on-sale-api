package com.onsale.onsaleapi.domains.cities.dto

import com.onsale.onsaleapi.domains.shared.types.ID

data class CreateCityResponseData(val id: ID, val name: String)
data class CreateCityResponse(val data: CreateCityResponseData)