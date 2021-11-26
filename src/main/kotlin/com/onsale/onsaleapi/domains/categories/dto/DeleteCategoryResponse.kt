package com.onsale.onsaleapi.domains.categories.dto

import com.onsale.onsaleapi.domains.shared.types.ID

data class DeleteCategoryResponseData(val id: ID, val name: String)

data class DeleteCategoryResponse(val data: DeleteCategoryResponseData)