package com.onsale.onsaleapi.domains.categories.dto

import com.onsale.onsaleapi.domains.shared.types.ID

data class CreateCategoryResponseData(val id: ID, val name: String)

data class CreateCategoryResponse(val data: CreateCategoryResponseData)