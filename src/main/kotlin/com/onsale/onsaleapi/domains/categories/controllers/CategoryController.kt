package com.onsale.onsaleapi.domains.categories.controllers

import com.onsale.onsaleapi.domains.categories.controllers.CategoryController.Companion.BASE_CATEGORY_URL
import com.onsale.onsaleapi.domains.categories.dto.*
import com.onsale.onsaleapi.domains.categories.mappers.*
import com.onsale.onsaleapi.domains.categories.services.ICategoryService
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_CATEGORY_URL])
class CategoryController(
    @Autowired val categoryService: ICategoryService,
    @Autowired val createCategoryResponseMapper: CreateCategoryResponseMapper,
    @Autowired val getCategoryByIdResponseMapper: GetCategoryByIdResponseMapper,
    @Autowired val getCategoriesResponseMapper: GetCategoriesResponseMapper,
    @Autowired val updateCategoryResponseMapper: UpdateCategoryResponseMapper,
    @Autowired val deleteCategoryResponseMapper: DeleteCategoryResponseMapper
) : ICategoryController {
    @GetMapping("/{id}")
    override fun getCategoryById(@PathVariable id: ID): ResponseEntity<GetCategoryByIdResponse> {
        val category = categoryService.getById(id) ?: return ResponseEntity.notFound().build()

        return ResponseEntity.ok(getCategoryByIdResponseMapper.transform(category))
    }

    @GetMapping
    override fun getAllCategories(): ResponseEntity<GetCategoriesResponse> {
        val categories = categoryService.getAll()

        return ResponseEntity.ok(getCategoriesResponseMapper.transform(categories))
    }

    @PostMapping
    override fun createCategory(@RequestBody request: CreateCategoryRequest): ResponseEntity<CreateCategoryResponse> {
        val category = categoryService.create(request)

        return ResponseEntity.created(URI.create("${BASE_CATEGORY_URL}${category.id}"))
            .body(createCategoryResponseMapper.transform(category))
    }

    @PatchMapping("/{id}")
    override fun updateCategory(
        @PathVariable id: ID,
        @RequestBody request: UpdateCategoryRequest
    ): ResponseEntity<UpdateCategoryResponse> {
        val category = categoryService.update(id, request)

        return ResponseEntity.ok(updateCategoryResponseMapper.transform(category))
    }

    @DeleteMapping("/{id}")
    override fun deleteCategory(@PathVariable id: ID): ResponseEntity<DeleteCategoryResponse> {
        val category = categoryService.delete(id)

        return ResponseEntity.ok(deleteCategoryResponseMapper.transform(category))
    }

    companion object {
        const val BASE_CATEGORY_URL = "categories/"
    }
}