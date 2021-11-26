package com.onsale.onsaleapi.domains.offers.db

import com.onsale.onsaleapi.domains.cities.entities.City
import com.onsale.onsaleapi.domains.cities.entities.fromDBRow
import com.onsale.onsaleapi.domains.companies.entities.Company
import com.onsale.onsaleapi.domains.companies.entities.fromDBRow
import com.onsale.onsaleapi.domains.offers.entities._Offer
import com.onsale.onsaleapi.domains.offers.entities.OfferJoined
import org.jetbrains.exposed.sql.ResultRow

fun _Offer.Companion.fromDBRow(row: ResultRow): _Offer {
    return _Offer(
            row[OffersTable.id].toString(),
            row[OffersTable.companyId].toString(),
            row[OffersTable.description],
            row[OffersTable.sale],
            row[OffersTable.cityId].toString(),
            row[OffersTable.createdAt],
    )
}

fun OfferJoined.Companion.fromDBRow(row: ResultRow): OfferJoined {
    return OfferJoined(
        row[OffersTable.id].toString(),
        Company.fromDBRow(row),
        row[OffersTable.description],
        row[OffersTable.sale],
        City.fromDBRow(row),
        row[OffersTable.createdAt],
    )
}