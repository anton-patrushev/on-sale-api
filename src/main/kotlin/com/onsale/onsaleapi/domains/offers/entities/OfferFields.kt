package com.onsale.onsaleapi.domains.offers.entities

import com.onsale.onsaleapi.domains.shared.types.ID

data class OfferFields(
        val companyId: ID?,
        val description: String?,
        val sale: String?,
        val cityId: ID?,
        val created_at: String?, // TODO: Date type
)