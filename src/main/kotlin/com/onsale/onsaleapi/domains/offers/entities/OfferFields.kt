package com.onsale.onsaleapi.domains.offers.entities

import com.onsale.onsaleapi.domains.shared.types.ID
import java.time.LocalDate

data class OfferFields(
        val companyId: ID?,
        val description: String?,
        val sale: String?,
        val cityId: ID?,
        val createdAt: LocalDate?
)