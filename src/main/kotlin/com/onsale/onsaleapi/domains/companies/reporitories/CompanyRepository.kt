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
    override fun create(employee: Company): Company {
        TODO("Not yet implemented")
//
//        transaction {
//            CompaniesTable.insert {
//                it[id] = UUID.fromString(employee.id)
//                it[firstName] = employee.firstName
//                it[lastName] = employee.lastName
//            }
//        }
//
//        return employee;
    }

    override fun getAll(): List<Company> {
        TODO("Not yet implemented")
//        return transaction {
//            CompaniesTable.selectAll().map(Company::fromDBRow)
//        }
    }

    override fun getById(id: ID): Company? {
        TODO("Not yet implemented")
//        val employee = transaction {
//            CompaniesTable.select { CompaniesTable.id eq UUID.fromString(id) }.map(Company::fromDBRow).getOrNull(0)
//        }
//
//        return employee
    }

    override fun update(id: ID, fieldsToUpdate: CompanyFields): Company? {
        TODO("Not yet implemented")
//        transaction {
//            CompaniesTable.update({ CompaniesTable.id eq UUID.fromString(id) }) {
//                if (fieldsToUpdate.firstName != null) it[firstName] = fieldsToUpdate.firstName
//                if (fieldsToUpdate.lastName != null) it[lastName] = fieldsToUpdate.lastName
//            }
//        }
//
//        return getById(id) as Company?
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: ID) {
        TODO("Not yet implemented")
//        transaction {
//            CompaniesTable.deleteWhere { CompaniesTable.id eq UUID.fromString(id) }
//        }
    }
}