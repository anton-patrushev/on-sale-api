package com.onsale.onsaleapi.domains.categories.db

import com.onsale.onsaleapi.domains.categories.entities.OfferCategory
import org.jetbrains.exposed.sql.ResultRow


fun OfferCategory.Companion.fromDBRow(row: ResultRow): OfferCategory {
    return OfferCategory(
        row[CategoriesTable.id].toString(),
        row[CategoriesTable.name],
    )
}