package com.onsale.onsaleapi.domains.offers.entities

import com.onsale.onsaleapi.domains.cities.entities.City
import com.onsale.onsaleapi.domains.companies.entities.Company
import com.onsale.onsaleapi.domains.shared.types.ID
import java.time.LocalDate

data class Offer (
    val id: ID,
    val company: Company,
    val description: String?,
    val sale: String?,
    val city: City,
    val createdAt: LocalDate
) {
    companion object {}
}