package com.onsale.onsaleapi.domains.categories.dto

import com.onsale.onsaleapi.domains.shared.types.ID

data class GetCategoriesResponseDataRow(val id: ID, val name: String)

data class GetCategoriesResponse(val data: List<GetCategoriesResponseDataRow>)