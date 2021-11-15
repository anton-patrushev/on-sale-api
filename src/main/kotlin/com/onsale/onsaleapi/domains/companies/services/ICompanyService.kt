package com.onsale.onsaleapi.domains.companies.services

import com.onsale.onsaleapi.domains.companies.dto.CreateCompanyRequest
import com.onsale.onsaleapi.domains.companies.dto.UpdateCompanyRequest
import com.onsale.onsaleapi.domains.companies.entities.Company
import com.onsale.onsaleapi.domains.shared.types.ID

interface ICompanyService {
    fun create(request: CreateCompanyRequest): Company
    fun edit(id: ID, request: UpdateCompanyRequest): Company?

    fun getById(id: ID): Company?
    fun getAll(): List<Company>

    fun deleteById(id: ID): Company?

}