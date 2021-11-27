package com.onsale.onsaleapi.domains.categories.db

import com.onsale.onsaleapi.domains.offers.db.OffersTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import java.util.UUID

object OffersCategoriesTable : Table("Offers_Categories") {
    val offerId: Column<UUID> = reference("offer_id", OffersTable.id)
    val categoryId: Column<UUID> = reference("category_id", CategoriesTable.id)
}