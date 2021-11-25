package com.onsale.onsaleapi.domains.likes.entities

import com.onsale.onsaleapi.domains.employees.entities.Employee
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.offers.entities.OfferJoined
import com.onsale.onsaleapi.domains.shared.types.ID

data class Like(
    val id: ID,
    val offer: OfferJoined,
    val employee: Employee
) {
    companion object {}
}