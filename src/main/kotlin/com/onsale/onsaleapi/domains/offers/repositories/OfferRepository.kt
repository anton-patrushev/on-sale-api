package com.onsale.onsaleapi.domains.offers.repositories

import com.onsale.onsaleapi.domains.categories.db.CategoriesTable
import com.onsale.onsaleapi.domains.categories.db.OffersCategoriesTable
import com.onsale.onsaleapi.domains.categories.db.fromDBRow
import com.onsale.onsaleapi.domains.categories.entities.OfferCategory
import com.onsale.onsaleapi.domains.cities.db.CitiesTable
import com.onsale.onsaleapi.domains.companies.db.CompaniesTable
import com.onsale.onsaleapi.domains.offers.db.OffersTable
import com.onsale.onsaleapi.domains.offers.db.fromDBRow
import com.onsale.onsaleapi.domains.offers.entities.RawOffer
import com.onsale.onsaleapi.domains.offers.entities.OfferFields
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.shared.types.ID
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class OfferRepository : IOfferRepository {
    override fun create(offer: RawOffer) {
        transaction {
            OffersTable.insert {
                it[id] = UUID.fromString(offer.id)
                it[companyId] = UUID.fromString(offer.companyId)
                it[description] = offer.description
                it[sale] = offer.sale
                it[cityId] = UUID.fromString(offer.cityId)
                it[createdAt] = offer.createdAt
            }
        }
    }

    override fun update(id: ID, fieldsToUpdate: OfferFields) {
        transaction {
            OffersTable.update({ OffersTable.id eq UUID.fromString(id) }) {
                if (fieldsToUpdate.description != null) it[description] = fieldsToUpdate.description
                if (fieldsToUpdate.sale != null) it[sale] = fieldsToUpdate.sale
                if (fieldsToUpdate.cityId != null) it[cityId] = UUID.fromString(fieldsToUpdate.cityId)
                if (fieldsToUpdate.sale != null) it[sale] = fieldsToUpdate.sale
            }
        }
    }

    override fun getById(id: ID): Offer? {
        val query = transaction {
            OffersCategoriesTable
                .rightJoin(OffersTable)
                .leftJoin(CategoriesTable)
                .leftJoin(CompaniesTable)
                .leftJoin(CitiesTable)
                .select { OffersTable.id eq UUID.fromString(id) }.map { it }
        }

        if (query.isEmpty()) return null

        return query[0].let { Offer.fromDBRow(it, query) }
    }

    override fun getAll(): List<Offer> {
        val query = transaction {
            OffersCategoriesTable
                .rightJoin(OffersTable)
                .leftJoin(CategoriesTable)
                .leftJoin(CompaniesTable)
                .leftJoin(CitiesTable)
                .selectAll().map { it }
        }



        return query.map {
            val offerRow = it
            val categories = query.filter {
                offerRow[OffersCategoriesTable.offerId] == it[OffersCategoriesTable.offerId]
            }

            Offer.fromDBRow(it, categories)
        }.distinctBy { it.id }
    }

    override fun deleteAll() {
        transaction {
            OffersTable.deleteAll()
        }
    }

    override fun deleteById(id: ID) {
        transaction {
            OffersTable.deleteWhere { OffersTable.id eq UUID.fromString(id) }
        }
    }
}