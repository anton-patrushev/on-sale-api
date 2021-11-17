package com.onsale.onsaleapi.domains.offers.repositories

import com.onsale.onsaleapi.domains.cities.db.CitiesTable
import com.onsale.onsaleapi.domains.companies.db.CompaniesTable
import com.onsale.onsaleapi.domains.offers.db.OffersTable
import com.onsale.onsaleapi.domains.offers.db.fromDBRow
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.offers.entities.OfferFields
import com.onsale.onsaleapi.domains.offers.entities.OfferJoined
import com.onsale.onsaleapi.domains.shared.types.ID
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class OfferRepository : IOfferRepository {
    override fun create(offer: Offer) {
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
            OffersTable.update {
                if (fieldsToUpdate.description != null) it[description] = fieldsToUpdate.description
                if (fieldsToUpdate.sale != null) it[sale] = fieldsToUpdate.sale
                if (fieldsToUpdate.cityId != null) it[cityId] = UUID.fromString(fieldsToUpdate.cityId)
                if (fieldsToUpdate.sale != null) it[sale] = fieldsToUpdate.sale
            }
        }
    }

    override fun getById(id: ID): Offer? {
        val query = transaction {
            OffersTable.select { OffersTable.id eq UUID.fromString(id) }.firstOrNull()
        } ?: return null

        return query.let(Offer.Companion::fromDBRow)
    }

    override fun getByIdJoined(id: ID): OfferJoined? {
        val query = transaction {
            OffersTable.leftJoin(CompaniesTable).leftJoin(CitiesTable)
                .select { OffersTable.id eq UUID.fromString(id) }.firstOrNull()
        } ?: return null

        return query.let(OfferJoined.Companion::fromDBRow)
    }

    override fun getAll(): List<Offer> {
        val query = transaction {
            OffersTable.selectAll()
        }

        return query.map(Offer.Companion::fromDBRow)
    }

    override fun getAllJoined(): List<OfferJoined> {
        val query = transaction {
            OffersTable.leftJoin(CompaniesTable).leftJoin(CitiesTable).selectAll().map { it }
        }

        return query.map(OfferJoined.Companion::fromDBRow)
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