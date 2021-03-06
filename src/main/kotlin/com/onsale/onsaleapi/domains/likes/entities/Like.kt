package com.onsale.onsaleapi.domains.likes.entities

import com.onsale.onsaleapi.domains.employees.entities.Employee
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.shared.types.ID

data class Like(
    val id: ID,
    val offer: Offer,
    val employee: Employee
) {
    companion object {}
}