package com.onsale.onsaleapi.domains.categories.dto

import com.onsale.onsaleapi.domains.shared.types.ID

data class GetCategoryByIdResponseData(val id: ID, val name: String)

data class GetCategoryByIdResponse(val data: GetCategoryByIdResponseData)