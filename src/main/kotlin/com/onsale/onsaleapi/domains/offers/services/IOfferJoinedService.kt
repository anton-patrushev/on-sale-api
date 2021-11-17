package com.onsale.onsaleapi.domains.offers.services

import com.onsale.onsaleapi.domains.offers.dto.CreateOfferRequest
import com.onsale.onsaleapi.domains.offers.dto.UpdateOfferRequest
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.offers.entities.OfferJoined
import com.onsale.onsaleapi.domains.shared.types.ID

interface IOfferJoinedService {
    fun create(request: CreateOfferRequest): OfferJoined

    fun edit(id: ID, request: UpdateOfferRequest): OfferJoined?

    fun getById(id: ID): OfferJoined?
    fun getAll(): List<OfferJoined>

    fun deleteById(id: ID): OfferJoined?
}