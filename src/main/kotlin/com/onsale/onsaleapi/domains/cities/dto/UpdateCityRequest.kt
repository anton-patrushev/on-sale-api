package com.onsale.onsaleapi.domains.cities.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class UpdateCityRequest(
    @JsonProperty("name") // required for single field requests
    val name: String?
)