package com.onsale.onsaleapi.domains.offers.controllers

import com.onsale.onsaleapi.domains.cities.services.ICityService
import com.onsale.onsaleapi.domains.companies.services.ICompanyService
import com.onsale.onsaleapi.domains.offers.controllers.OfferController.Companion.BASE_OFFER_URL
import com.onsale.onsaleapi.domains.offers.dto.*
import com.onsale.onsaleapi.domains.offers.entities.OfferJoined
import com.onsale.onsaleapi.domains.offers.mappers.*
import com.onsale.onsaleapi.domains.offers.mappers.common.OfferResponseMapperAdditionalParams
import com.onsale.onsaleapi.domains.offers.services.IOfferService
import com.onsale.onsaleapi.domains.offers.services.OfferJoinedService
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_OFFER_URL])
class OfferController(
    @Autowired val offerService: IOfferService,
    @Autowired val offerJoinedService: OfferJoinedService,
    @Autowired val companyService: ICompanyService,
    @Autowired val cityService: ICityService,
    @Autowired val getByIdOfferResponseMapper: GetByIdOfferResponseMapper,
    @Autowired val getJoinedOffersResponseMapper: GetJoinedOffersResponseMapper,
    @Autowired val createJoinedOfferResponseMapper: CreateJoinedOfferResponseMapper,
    @Autowired val updateJoinedOfferResponseMapper: UpdateJoinedOfferResponseMapper,
    @Autowired val deleteJoinedOfferResponseMapper: DeleteJoinedOfferResponseMapper,
) : IOfferController {

    companion object {
        const val BASE_OFFER_URL = "offers/"
    }

    @GetMapping("/{id}")
    override fun getOfferById(@PathVariable id: ID): ResponseEntity<GetByIdOfferResponse> {
        val offer = offerService.getById(id) ?: return ResponseEntity.notFound().build()

        val company = companyService.getById(offer.companyId) ?: return ResponseEntity.internalServerError().build()
        val city = cityService.getById(offer.cityId) ?: return ResponseEntity.internalServerError().build()

        return ResponseEntity.ok(
            getByIdOfferResponseMapper.transform(offer, OfferResponseMapperAdditionalParams(company, city))
        )
    }

    @GetMapping
    override fun getOffers(): ResponseEntity<GetOffersResponse> {
        val joinedOffers = offerJoinedService.getAll()

        return ResponseEntity.ok(
            getJoinedOffersResponseMapper.transform(joinedOffers)
        )
    }

    @PostMapping
    override fun createOffer(@RequestBody request: CreateOfferRequest): ResponseEntity<CreateOfferResponse> {
        val offer = offerJoinedService.create(request)

        return ResponseEntity.created(URI.create("${BASE_OFFER_URL}/${offer.id}"))
            .body(createJoinedOfferResponseMapper.transform(offer))
    }

    @PatchMapping("/{id}")
    override fun updateOffer(
        @PathVariable id: ID,
        @RequestBody request: UpdateOfferRequest
    ): ResponseEntity<UpdateOfferResponse> {
        val offer = offerJoinedService.edit(id, request)

        return when(offer) {
            is OfferJoined -> ResponseEntity.ok(updateJoinedOfferResponseMapper.transform(offer))
            else -> ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteOffer(@PathVariable id: ID): ResponseEntity<DeleteOfferResponse> {
        val offer = offerJoinedService.deleteById(id)

        return when(offer) {
            is OfferJoined -> ResponseEntity.ok(deleteJoinedOfferResponseMapper.transform(offer))
            else -> ResponseEntity.notFound().build()
        }
    }
}