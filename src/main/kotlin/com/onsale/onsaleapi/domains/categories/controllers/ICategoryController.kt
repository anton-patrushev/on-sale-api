package com.onsale.onsaleapi.domains.categories.controllers

import com.onsale.onsaleapi.domains.categories.dto.*
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.http.ResponseEntity

interface ICategoryController {
    fun getCategoryById(id: ID): ResponseEntity<GetCategoryByIdResponse>
    fun getAllCategories(): ResponseEntity<GetCategoriesResponse>
    fun createCategory(request: CreateCategoryRequest): ResponseEntity<CreateCategoryResponse>
    fun updateCategory(id:ID, request: UpdateCategoryRequest): ResponseEntity<UpdateCategoryResponse>
    fun deleteCategory(id: ID): ResponseEntity<DeleteCategoryResponse>
}