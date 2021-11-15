package com.onsale.onsaleapi.domains.companies.entities

import com.onsale.onsaleapi.domains.companies.db.CompaniesTable
import com.onsale.onsaleapi.domains.shared.types.ID
import org.jetbrains.exposed.sql.ResultRow

data class Company(
        val id: ID,
        val name: String,
        val websiteURL: String?,
        val email: String?,
        val phone: String?,
        val workSchedule: String?
) {
    companion object {}
}

data class CompanyFields(
        val name: String?,
        val websiteURL: String?,
        val email: String?,
        val phone: String?,
        val workSchedule: String?
)

// TODO: move into better place
fun Company.Companion.fromDBRow(row: ResultRow): Company {
    return Company(
            row[CompaniesTable.id].toString(),
            row[CompaniesTable.name],
            row[CompaniesTable.websiteURL].toString(),
            row[CompaniesTable.email].toString(),
            row[CompaniesTable.phone].toString(),
            row[CompaniesTable.workSchedule].toString()
    )
}