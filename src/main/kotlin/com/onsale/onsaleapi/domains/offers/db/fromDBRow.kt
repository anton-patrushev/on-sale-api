package com.onsale.onsaleapi.domains.offers.db

import com.onsale.onsaleapi.domains.offers.entities.Offer
import org.jetbrains.exposed.sql.ResultRow

fun Offer.Companion.fromDBRow(row: ResultRow): Offer {
    return Offer(
            row[OffersTable.id].toString(),
            row[OffersTable.companyId].toString(),
            row[OffersTable.description],
            row[OffersTable.sale],
            row[OffersTable.cityId].toString(),
            row[OffersTable.createdAt].toString(),
    )
}