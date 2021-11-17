package com.onsale.onsaleapi.domains.companies.reporitories

import com.onsale.onsaleapi.domains.companies.db.CompaniesTable
import com.onsale.onsaleapi.domains.companies.entities.Company
import com.onsale.onsaleapi.domains.companies.entities.CompanyFields
import com.onsale.onsaleapi.domains.companies.entities.fromDBRow
import com.onsale.onsaleapi.domains.shared.types.ID
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class CompanyRepository : ICompanyRepository {
    override fun create(company: Company) {
        transaction {
            CompaniesTable.insert {
                it[id] = UUID.fromString(company.id)
                it[name] = company.name
                it[websiteURL] = company.websiteURL
                it[email] = company.email
                it[phone] = company.phone
                it[workSchedule] = company.workSchedule
            }
        }
    }

    override fun getAll(): List<Company> {
        return transaction {
            CompaniesTable.selectAll().map(Company::fromDBRow)
        }
    }

    override fun getById(id: ID): Company? {
        val company = transaction {
            CompaniesTable.select { CompaniesTable.id eq UUID.fromString(id) }.firstOrNull()
        } ?: return null

        return company.let(Company.Companion::fromDBRow)
    }

    override fun update(id: ID, fieldsToUpdate: CompanyFields) {
        transaction {
            CompaniesTable.update({ CompaniesTable.id eq UUID.fromString(id) }) {
                if (fieldsToUpdate.name != null) it[name] = fieldsToUpdate.name
                if (fieldsToUpdate.websiteURL != null) it[websiteURL] = fieldsToUpdate.websiteURL
                if (fieldsToUpdate.email != null) it[email] = fieldsToUpdate.email
                if (fieldsToUpdate.phone != null) it[phone] = fieldsToUpdate.phone
                if (fieldsToUpdate.workSchedule != null) it[workSchedule] = fieldsToUpdate.workSchedule
            }
        }
    }

    override fun deleteAll() {
        transaction {
            CompaniesTable.deleteAll()
        }
    }

    override fun deleteById(id: ID) {
        transaction {
            CompaniesTable.deleteWhere { CompaniesTable.id eq UUID.fromString(id) }
        }
    }
}