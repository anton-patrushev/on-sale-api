package com.onsale.onsaleapi.domains.categories.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class UpdateCategoryRequest(
    @JsonProperty("name") // Required for single field requests
    val name: String
)