package com.onsale.onsaleapi.domains.companies.reporitories

import com.onsale.onsaleapi.domains.companies.entities.Company
import com.onsale.onsaleapi.domains.companies.entities.CompanyFields
import com.onsale.onsaleapi.domains.shared.types.ID

interface ICompanyRepository {
    fun create(company: Company)

    fun getAll(): List<Company>
    fun getById(id: ID): Company?

    fun update(id: ID, fieldsToUpdate: CompanyFields)

    fun deleteAll()
    fun deleteById(id: ID)
}