package com.onsale.onsaleapi.domains.offers.controllers

import com.onsale.onsaleapi.domains.offers.controllers.OfferController.Companion.BASE_OFFER_URL
import com.onsale.onsaleapi.domains.offers.dto.*
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.offers.mappers.*
import com.onsale.onsaleapi.domains.offers.services.OfferService
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_OFFER_URL])
class OfferController(
    @Autowired val offerService: OfferService,
    @Autowired val getByIdOfferResponseMapper: GetOfferByIdResponseMapper,
    @Autowired val getOffersResponseMapper: GetOffersResponseMapper,
    @Autowired val createOfferResponseMapper: CreateOfferResponseMapper,
    @Autowired val updateOfferResponseMapper: UpdateOfferResponseMapper,
    @Autowired val deleteOfferResponseMapper: DeleteOfferResponseMapper,
) : IOfferController {

    companion object {
        const val BASE_OFFER_URL = "offers/"
    }

    @GetMapping("/{id}")
    override fun getOfferById(@PathVariable id: ID): ResponseEntity<GetByIdOfferResponse> {
        val offer = offerService.getById(id) ?: return ResponseEntity.notFound().build()

        return ResponseEntity.ok(
            getByIdOfferResponseMapper.transform(offer)
        )
    }

    @GetMapping
    override fun getOffers(): ResponseEntity<GetOffersResponse> {
        val joinedOffers = offerService.getAll()

        return ResponseEntity.ok(
            getOffersResponseMapper.transform(joinedOffers)
        )
    }

    @PostMapping
    override fun createOffer(@RequestBody request: CreateOfferRequest): ResponseEntity<CreateOfferResponse> {
        val offer = offerService.create(request)

        return ResponseEntity.created(URI.create("${BASE_OFFER_URL}/${offer.id}"))
            .body(createOfferResponseMapper.transform(offer))
    }

    @PatchMapping("/{id}")
    override fun updateOffer(
        @PathVariable id: ID,
        @RequestBody request: UpdateOfferRequest
    ): ResponseEntity<UpdateOfferResponse> {
        val offer = offerService.edit(id, request)

        return when (offer) {
            is Offer -> ResponseEntity.ok(updateOfferResponseMapper.transform(offer))
            else -> ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteOffer(@PathVariable id: ID): ResponseEntity<DeleteOfferResponse> {
        val offer = offerService.deleteById(id)

        return when (offer) {
            is Offer -> ResponseEntity.ok(deleteOfferResponseMapper.transform(offer))
            else -> ResponseEntity.notFound().build()
        }
    }
}