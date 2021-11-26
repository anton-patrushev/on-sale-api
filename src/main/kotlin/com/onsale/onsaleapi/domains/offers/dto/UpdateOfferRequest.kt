package com.onsale.onsaleapi.domains.offers.dto

import com.onsale.onsaleapi.domains.shared.types.ID

data class UpdateOfferRequest(
    val description: String?,
    val sale: String?,
    val city_id: ID?,
    val created_at: String?,
    val categories: List<ID>?,
)