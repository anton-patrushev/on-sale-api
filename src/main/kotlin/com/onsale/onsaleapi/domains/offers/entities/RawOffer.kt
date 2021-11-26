package com.onsale.onsaleapi.domains.offers.entities

import com.onsale.onsaleapi.domains.shared.types.ID
import java.time.LocalDate

data class RawOffer(
    val id: ID,
    val companyId: ID,
    val description: String?,
    val sale: String?,
    val cityId: ID,
    val createdAt: LocalDate,
) {
    companion object {}
}

