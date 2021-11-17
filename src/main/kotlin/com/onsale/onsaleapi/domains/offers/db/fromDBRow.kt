package com.onsale.onsaleapi.domains.offers.db

import com.onsale.onsaleapi.domains.offers.entities.Offer
import org.jetbrains.exposed.sql.ResultRow

fun Offer.Companion.fromDBRow(row: ResultRow): Offer {
    return Offer(
            row[OffersTable.id].toString(),
//            row[OffersTable.companyId].toString(),
            "a5eebc99-9c0b-4ef8-bb6d-6bb9bd380a11",
            row[OffersTable.description],
            row[OffersTable.sale],
//            row[OffersTable.cityId].toString(),
            "a1eebc99-9c0b-4ef8-bb6d-6bb9bd380a11",
//            row[OffersTable.createdAt].toString(),
    "2016-05-26"
    )
}