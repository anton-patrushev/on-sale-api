package com.onsale.onsaleapi.domains.offers.repositories

import com.onsale.onsaleapi.domains.offers.db.OffersTable
import com.onsale.onsaleapi.domains.offers.db.fromDBRow
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.offers.entities.OfferFields
import com.onsale.onsaleapi.domains.shared.types.ID
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class OfferRepository : IOfferRepository {
    override fun create(offer: Offer) {
        TODO("Not yet implemented")
    }

    override fun update(id: ID, fieldsToUpdate: OfferFields) {
        TODO("Not yet implemented")
    }

    override fun getById(id: ID): Offer? {
        val query = transaction {
            OffersTable.select { OffersTable.id eq UUID.fromString(id) }.firstOrNull()
        } ?: return null

        return query.let(Offer.Companion::fromDBRow)
    }

    override fun getAll(): List<Offer> {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: ID) {
        TODO("Not yet implemented")
    }
}