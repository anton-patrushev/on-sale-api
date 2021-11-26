package com.onsale.onsaleapi.domains.categories.repositories

import com.onsale.onsaleapi.domains.categories.entities.OfferCategory
import com.onsale.onsaleapi.domains.categories.entities.OfferCategoryFields
import com.onsale.onsaleapi.domains.shared.types.ID

interface ICategoryRepository {
    fun getById(id: ID): OfferCategory?
    fun getAll(): List<OfferCategory>

    fun create(category: OfferCategory)
    fun update(id: ID, categoryFields: OfferCategoryFields)
    fun deleteById(id: ID)
    fun deleteAll()
}