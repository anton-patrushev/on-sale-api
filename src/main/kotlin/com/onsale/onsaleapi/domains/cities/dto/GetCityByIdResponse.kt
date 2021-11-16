package com.onsale.onsaleapi.domains.cities.dto

import com.onsale.onsaleapi.domains.shared.types.ID

data class GetCityByIdResponseData(val id: ID, val name: String)
data class GetCityByIdResponse(val data: GetCityByIdResponseData)