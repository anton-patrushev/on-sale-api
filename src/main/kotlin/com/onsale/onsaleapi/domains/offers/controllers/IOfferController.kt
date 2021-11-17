package com.onsale.onsaleapi.domains.offers.controllers

import com.onsale.onsaleapi.domains.offers.dto.*
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.http.ResponseEntity

interface IOfferController {
    fun getOfferById(id: ID): ResponseEntity<GetByIdOfferResponse>
    fun getOffers(): ResponseEntity<GetOffersResponse>

    fun createOffer(request: CreateOfferRequest): ResponseEntity<CreateOfferResponse>

    fun updateOffer(id:ID, request: UpdateOfferRequest): ResponseEntity<UpdateOfferResponse>

    fun deleteOffer(id: ID): ResponseEntity<DeleteOfferResponse>
}