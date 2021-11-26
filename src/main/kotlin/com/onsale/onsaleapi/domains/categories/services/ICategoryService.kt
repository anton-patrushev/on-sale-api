package com.onsale.onsaleapi.domains.categories.services

import com.onsale.onsaleapi.domains.categories.dto.CreateCategoryRequest
import com.onsale.onsaleapi.domains.categories.dto.UpdateCategoryRequest
import com.onsale.onsaleapi.domains.categories.entities.OfferCategory
import com.onsale.onsaleapi.domains.shared.types.ID

interface ICategoryService {
    fun getById(id: ID): OfferCategory?
    fun getAll(): List<OfferCategory>
    fun create(request: CreateCategoryRequest): OfferCategory
    fun update(id:ID, request: UpdateCategoryRequest): OfferCategory
    fun delete(id: ID): OfferCategory
}