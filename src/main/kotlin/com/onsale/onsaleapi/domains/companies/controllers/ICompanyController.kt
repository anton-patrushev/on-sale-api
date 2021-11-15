package com.onsale.onsaleapi.domains.companies.controllers

import com.onsale.onsaleapi.domains.companies.dto.CreateCompanyRequest
import com.onsale.onsaleapi.domains.companies.dto.CreateCompanyResponse
import com.onsale.onsaleapi.domains.companies.dto.DeleteCompanyByIdResponse
import com.onsale.onsaleapi.domains.companies.dto.GetCompanyByIdResponse
import com.onsale.onsaleapi.domains.companies.dto.GetAllCompaniesResponse
import com.onsale.onsaleapi.domains.companies.dto.UpdateCompanyRequest
import com.onsale.onsaleapi.domains.companies.dto.UpdateCompanyResponse
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.http.ResponseEntity

interface ICompanyController {
    fun createCompany(request: CreateCompanyRequest): ResponseEntity<CreateCompanyResponse>
    fun getCompanyById(id: ID): ResponseEntity<GetCompanyByIdResponse>
    fun getAllCompanies(): ResponseEntity<GetAllCompaniesResponse>
    fun deleteCompanyById(id: ID): ResponseEntity<DeleteCompanyByIdResponse>
    fun updateCompanyById(id: ID, request: UpdateCompanyRequest): ResponseEntity<UpdateCompanyResponse>
}