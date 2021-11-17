package com.onsale.onsaleapi.domains.cities.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateCityRequest(
    @JsonProperty("name") // Required for single field requests
    val name: String
)
