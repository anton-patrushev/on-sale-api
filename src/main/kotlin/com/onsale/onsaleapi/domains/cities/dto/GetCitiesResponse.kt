package com.onsale.onsaleapi.domains.cities.dto

import com.onsale.onsaleapi.domains.shared.types.ID


data class GetCitiesResponseRow(val id: ID, val name: String)
data class GetCitiesResponse(val data: List<GetCitiesResponseRow>)