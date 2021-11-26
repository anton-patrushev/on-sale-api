package com.onsale.onsaleapi.domains.offers.services

import com.onsale.onsaleapi.domains.offers.dto.CreateOfferRequest
import com.onsale.onsaleapi.domains.offers.dto.UpdateOfferRequest
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.shared.types.ID

interface IOfferJoinedService {
    fun create(request: CreateOfferRequest): Offer

    fun edit(id: ID, request: UpdateOfferRequest): Offer?

    fun getById(id: ID): Offer?
    fun getAll(): List<Offer>

    fun deleteById(id: ID): Offer?
}