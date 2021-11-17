package com.onsale.onsaleapi.domains.offers.repositories

import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.offers.entities.OfferFields
import com.onsale.onsaleapi.domains.offers.entities.OfferJoined
import com.onsale.onsaleapi.domains.shared.types.ID

interface IOfferRepository {
    fun create(offer: Offer)
    fun update(id: ID, fieldsToUpdate: OfferFields)

    fun getById(id: ID): Offer?
    fun getByIdJoined(id: ID): OfferJoined?

    fun getAll(): List<Offer>
    fun getAllJoined(): List<OfferJoined>

    fun deleteAll()
    fun deleteById(id: ID)
}