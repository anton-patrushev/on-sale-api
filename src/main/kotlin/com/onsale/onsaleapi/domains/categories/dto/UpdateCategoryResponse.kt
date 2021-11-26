package com.onsale.onsaleapi.domains.categories.dto

import com.onsale.onsaleapi.domains.shared.types.ID

data class UpdateCategoryResponseData(val id: ID, val name: String)

data class UpdateCategoryResponse(val data: UpdateCategoryResponseData)