package com.onsale.onsaleapi.domains.offers.repositories

import com.onsale.onsaleapi.domains.offers.entities._Offer
import com.onsale.onsaleapi.domains.offers.entities.OfferFields
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.shared.types.ID

interface IOfferRepository {
    fun create(offer: _Offer)
    fun update(id: ID, fieldsToUpdate: OfferFields)

    fun getById(id: ID): _Offer?
    fun getByIdJoined(id: ID): Offer?

    fun getAll(): List<_Offer>
    fun getAllJoined(): List<Offer>

    fun deleteAll()
    fun deleteById(id: ID)
}