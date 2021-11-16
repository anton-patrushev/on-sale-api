package com.onsale.onsaleapi.domains.cities.dto

import com.onsale.onsaleapi.domains.shared.types.ID

data class DeleteCityByIdResponseData(val id: ID, val name: String)
data class DeleteCityByIdResponse(val data: DeleteCityByIdResponseData)