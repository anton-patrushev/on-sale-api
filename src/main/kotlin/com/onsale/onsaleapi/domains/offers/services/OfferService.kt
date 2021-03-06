package com.onsale.onsaleapi.domains.offers.services

import com.onsale.onsaleapi.domains.offers.dto.CreateOfferRequest
import com.onsale.onsaleapi.domains.offers.dto.UpdateOfferRequest
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.offers.mappers.CreateOfferRequestAdditionalParams
import com.onsale.onsaleapi.domains.offers.mappers.CreateOfferRequestMapper
import com.onsale.onsaleapi.domains.offers.mappers.UpdateOfferRequestMapper
import com.onsale.onsaleapi.domains.offers.repositories.IOfferRepository
import com.onsale.onsaleapi.domains.shared.services.UUIDService
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OfferService(
    @Autowired val uuidService: UUIDService,
    @Autowired val offerRepository: IOfferRepository,
    @Autowired val createOfferRequestMapper: CreateOfferRequestMapper,
    @Autowired val updateOfferRequestMapper: UpdateOfferRequestMapper,
) : IOfferService {
    override fun create(request: CreateOfferRequest): Offer {
        val id = uuidService.getUUID()
        val offer = createOfferRequestMapper.transform(request, CreateOfferRequestAdditionalParams(id))

        offerRepository.create(offer)

        return offerRepository.getById(offer.id) as Offer
    }

    override fun edit(id: ID, request: UpdateOfferRequest): Offer? {
        val offerFields = updateOfferRequestMapper.transform(request)

        offerRepository.update(id, offerFields)

        // TODO: update Offers_Categories table to apply `categories` field

        return offerRepository.getById(id)
    }

    override fun getById(id: ID): Offer? {
        return offerRepository.getById(id)
    }

    override fun getAll(): List<Offer> {
        return offerRepository.getAll()
    }

    override fun deleteById(id: ID): Offer? {
        val offer = offerRepository.getById(id) ?: return null

        offerRepository.deleteById(offer.id)

        return offer
    }
}