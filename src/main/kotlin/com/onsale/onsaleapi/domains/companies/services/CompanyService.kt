package com.onsale.onsaleapi.domains.companies.services

import com.onsale.onsaleapi.domains.companies.dto.CreateCompanyRequest
import com.onsale.onsaleapi.domains.companies.dto.UpdateCompanyRequest
import com.onsale.onsaleapi.domains.companies.entities.Company
import com.onsale.onsaleapi.domains.companies.mappers.CreateCompanyRequestMapper
import com.onsale.onsaleapi.domains.companies.mappers.CreateCompanyRequestMapperAdditionalParams
import com.onsale.onsaleapi.domains.companies.mappers.UpdateCompanyRequestMapper
import com.onsale.onsaleapi.domains.companies.reporitories.ICompanyRepository
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
        ): ICompanyService {
    override fun create(request: CreateCompanyRequest): Company {
        TODO("Not yet implemented")
//        val uuid = uuidService.getUUID()
//        val additionalMapperParams = CreateCompanyRequestMapperAdditionalParams(uuid)
//
//        return companyRepository.create(createCompanyRequestMapper.transform(request, additionalMapperParams))
    }

    override fun edit(id:ID, request: UpdateCompanyRequest): Company? {
        TODO("Not yet implemented")
//        val companyFieldsToUpdate = updateCompanyRequestMapper.transform(request)
//
//        return companyRepository.update(id, companyFieldsToUpdate)
    }

    override fun getById(id: ID): Company? {
        TODO("Not yet implemented")
//        return companyRepository.getById(id)
    }

    override fun getAll(): List<Company> {
        TODO("Not yet implemented")
//        return companyRepository.getAll()
    }

    override fun deleteById(id: ID): Company? {
        TODO("Not yet implemented")
//        val company = companyRepository.getById(id)
//        companyRepository.deleteById(id)
//
//        return company
    }

}