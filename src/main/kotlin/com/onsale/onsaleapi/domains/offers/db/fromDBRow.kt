package com.onsale.onsaleapi.domains.offers.db

import com.onsale.onsaleapi.domains.categories.db.CategoriesTable
import com.onsale.onsaleapi.domains.categories.db.fromDBRow
import com.onsale.onsaleapi.domains.categories.entities.OfferCategory
import com.onsale.onsaleapi.domains.cities.entities.City
import com.onsale.onsaleapi.domains.cities.entities.fromDBRow
import com.onsale.onsaleapi.domains.companies.entities.Company
import com.onsale.onsaleapi.domains.companies.entities.fromDBRow
import com.onsale.onsaleapi.domains.offers.entities.RawOffer
import com.onsale.onsaleapi.domains.offers.entities.Offer
import org.jetbrains.exposed.sql.ResultRow

fun RawOffer.Companion.fromDBRow(row: ResultRow): RawOffer {
    return RawOffer(
        row[OffersTable.id].toString(),
        row[OffersTable.companyId].toString(),
        row[OffersTable.description],
        row[OffersTable.sale],
        row[OffersTable.cityId].toString(),
        row[OffersTable.createdAt],
    )
}

fun Offer.Companion.fromDBRow(row: ResultRow, query: List<ResultRow>? = null): Offer {
    val categories = query
        ?.filter { it[CategoriesTable.id] != null }
        ?.map(OfferCategory.Companion::fromDBRow)

    return Offer(
        row[OffersTable.id].toString(),
        company = Company.fromDBRow(row),
        row[OffersTable.description],
        row[OffersTable.sale],
        city = City.fromDBRow(row),
        row[OffersTable.createdAt],
        categories = if (categories?.isEmpty() == true) null else categories
    )
}