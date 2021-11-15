package com.onsale.onsaleapi.domains.companies.controllers

import com.onsale.onsaleapi.domains.companies.controllers.CompanyController.Companion.BASE_COMPANY_URL
import com.onsale.onsaleapi.domains.companies.dto.*
import com.onsale.onsaleapi.domains.companies.entities.Company
import com.onsale.onsaleapi.domains.companies.mappers.*
import com.onsale.onsaleapi.domains.companies.services.ICompanyService
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_COMPANY_URL])
class CompanyController(
        @Autowired private val companyService: ICompanyService,
        @Autowired private val createCompanyResponseMapper: CreateCompanyResponseMapper,
        @Autowired private val updateCompanyResponseMapper: UpdateCompanyResponseMapper,
        @Autowired private val getCompanyByIdResponseMapper: GetCompanyByIdResponseMapper,
        @Autowired private val getAllCompaniesResponseMapper: GetAllCompaniesResponseMapper,
        @Autowired private val deleteCompanyByIdResponseMapper: DeleteCompanyByIdResponseMapper
        ): ICompanyController {

    @PostMapping
    override fun createCompany(@RequestBody request: CreateCompanyRequest): ResponseEntity<CreateCompanyResponse> {
        val company = companyService.create(request)

        return ResponseEntity
                .created(URI.create(BASE_COMPANY_URL.plus("/${company.id}")))
                .body(createCompanyResponseMapper.transform(company))
    }

    @GetMapping("/{id}")
    override fun getCompanyById(@PathVariable id: ID): ResponseEntity<GetCompanyByIdResponse> {
        val company = companyService.getById(id)

        return when (company) {
            is Company -> ResponseEntity
                    .accepted()
                    .body(getCompanyByIdResponseMapper.transform(company))
            else -> ResponseEntity.notFound().build()
        }
    }

    @GetMapping
    override fun getAllCompanies(): ResponseEntity<GetAllCompaniesResponse> {
        val companies = companyService.getAll()

        return ResponseEntity
                .accepted()
                .body(getAllCompaniesResponseMapper.transform(companies))
    }

    @DeleteMapping("/{id}")
    override fun deleteCompanyById(@PathVariable id: ID): ResponseEntity<DeleteCompanyByIdResponse> {
        val company = companyService.deleteById(id)

        return when (company) {
            is Company -> ResponseEntity.ok(deleteCompanyByIdResponseMapper.transform(company))
            else -> ResponseEntity.notFound().build()
        }
    }

    @PatchMapping("/{id}")
    override fun updateCompanyById(@PathVariable id: ID, @RequestBody request: UpdateCompanyRequest): ResponseEntity<UpdateCompanyResponse> {
        val company = companyService.edit(id, request)

        return when (company) {
            is Company -> ResponseEntity.ok(updateCompanyResponseMapper.transform(company))
            else -> ResponseEntity.notFound().build()
        }
    }

    companion object {
        const val BASE_COMPANY_URL = "companies/"
    }
}