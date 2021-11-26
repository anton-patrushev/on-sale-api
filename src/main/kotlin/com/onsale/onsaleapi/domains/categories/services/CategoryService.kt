package com.onsale.onsaleapi.domains.categories.services

import com.onsale.onsaleapi.domains.categories.dto.CreateCategoryRequest
import com.onsale.onsaleapi.domains.categories.dto.UpdateCategoryRequest
import com.onsale.onsaleapi.domains.categories.entities.OfferCategory
import com.onsale.onsaleapi.domains.categories.mappers.CreateCategoryRequestAdditionalParams
import com.onsale.onsaleapi.domains.categories.mappers.CreateCategoryRequestMapper
import com.onsale.onsaleapi.domains.categories.mappers.UpdateCategoryRequestMapper
import com.onsale.onsaleapi.domains.categories.repositories.ICategoryRepository
import com.onsale.onsaleapi.domains.shared.services.UUIDService
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryService(
    @Autowired val uuidService: UUIDService,
    @Autowired val categoryRepository: ICategoryRepository,
    @Autowired val createCategoryRequestMapper: CreateCategoryRequestMapper,
    @Autowired val updateCategoryRequestMapper: UpdateCategoryRequestMapper
) : ICategoryService {
    override fun getById(id: ID): OfferCategory? {
        return categoryRepository.getById(id)
    }

    override fun getAll(): List<OfferCategory> {
        return categoryRepository.getAll()
    }

    override fun create(request: CreateCategoryRequest): OfferCategory {
        val id = uuidService.getUUID()
        val category = createCategoryRequestMapper.transform(request, CreateCategoryRequestAdditionalParams(id))

        categoryRepository.create(category)

        return categoryRepository.getById(category.id) as OfferCategory
    }

    override fun update(id: ID, request: UpdateCategoryRequest): OfferCategory {
        val categoryFields = updateCategoryRequestMapper.transform(request)

        categoryRepository.update(id, categoryFields)

        return categoryRepository.getById(id) as OfferCategory
    }

    override fun delete(id: ID): OfferCategory {
        val category = categoryRepository.getById(id)

        categoryRepository.deleteById(id)

        return category as OfferCategory
    }

}