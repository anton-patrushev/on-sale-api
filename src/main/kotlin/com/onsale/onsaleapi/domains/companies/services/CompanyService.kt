package com.onsale.onsaleapi.domains.companies.services

import com.onsale.onsaleapi.domains.companies.dto.CreateCompanyRequest
import com.onsale.onsaleapi.domains.companies.dto.UpdateCompanyRequest
import com.onsale.onsaleapi.domains.companies.entities.Company
import com.onsale.onsaleapi.domains.companies.mappers.CreateCompanyRequestMapper
import com.onsale.onsaleapi.domains.companies.mappers.CreateCompanyRequestMapperAdditionalParams
import com.onsale.onsaleapi.domains.companies.mappers.UpdateCompanyRequestMapper
import com.onsale.onsaleapi.domains.companies.reporitories.ICompanyRepository
import com.onsale.onsaleapi.domains.offers.services.IOfferService
import com.onsale.onsaleapi.domains.shared.services.IUUIDService
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CompanyService(
    @Autowired private val companyRepository: ICompanyRepository,
    @Autowired private val createCompanyRequestMapper: CreateCompanyRequestMapper,
    @Autowired private val updateCompanyRequestMapper: UpdateCompanyRequestMapper,
    @Autowired private val uuidService: IUUIDService
) : ICompanyService {
    override fun create(request: CreateCompanyRequest): Company {
        val uuid = uuidService.getUUID()
        val additionalMapperParams = CreateCompanyRequestMapperAdditionalParams(uuid)

        companyRepository.create(createCompanyRequestMapper.transform(request, additionalMapperParams))

        return companyRepository.getById(uuid) as Company
    }

    override fun edit(id: ID, request: UpdateCompanyRequest): Company? {
        val companyFieldsToUpdate = updateCompanyRequestMapper.transform(request)

        companyRepository.update(id, companyFieldsToUpdate)

        return companyRepository.getById(id) as Company
    }

    override fun getById(id: ID): Company? {
        return companyRepository.getById(id)
    }

    override fun getAll(): List<Company> {
        return companyRepository.getAll()
    }

    override fun deleteById(id: ID): Company? {
        val company = companyRepository.getById(id) ?: return null

        companyRepository.deleteById(company.id)

        return company
    }

}