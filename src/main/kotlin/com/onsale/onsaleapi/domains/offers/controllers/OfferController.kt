package com.onsale.onsaleapi.domains.offers.controllers

import com.onsale.onsaleapi.domains.cities.services.ICityService
import com.onsale.onsaleapi.domains.companies.services.ICompanyService
import com.onsale.onsaleapi.domains.offers.controllers.OfferController.Companion.BASE_OFFER_URL
import com.onsale.onsaleapi.domains.offers.dto.*
import com.onsale.onsaleapi.domains.offers.mappers.GetByIdOfferResponseMapper
import com.onsale.onsaleapi.domains.offers.mappers.UpdateOfferRequestMapper
import com.onsale.onsaleapi.domains.offers.mappers.common.OfferResponseMapperAdditionalParams
import com.onsale.onsaleapi.domains.offers.services.IOfferService
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = [BASE_OFFER_URL])
class OfferController(
        @Autowired val offerService: IOfferService,
        @Autowired val companyService: ICompanyService,
        @Autowired val cityService: ICityService,
        @Autowired val createOfferRequestMapper: UpdateOfferRequestMapper,
        @Autowired val getByIdOfferResponseMapper: GetByIdOfferResponseMapper,
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
        TODO("Not yet implemented")
    }

    @PostMapping
    override fun createOffer(@RequestBody request: CreateOfferRequest): ResponseEntity<CreateOfferResponse> {
        TODO("Not yet implemented")
    }

    @PatchMapping("/{id}")
    override fun updateOffer(@PathVariable id:ID, @RequestBody request: UpdateOfferRequest): ResponseEntity<UpdateOfferResponse> {
        TODO("Not yet implemented")
    }

    @DeleteMapping("/{id}")
    override fun deleteOffer(@PathVariable id: ID): ResponseEntity<DeleteOfferResponse> {
        TODO("Not yet implemented")
    }
}