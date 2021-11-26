package com.onsale.onsaleapi.domains.offers.services

import com.onsale.onsaleapi.domains.likes.repositories.ILikeRepository
import com.onsale.onsaleapi.domains.offers.dto.CreateOfferRequest
import com.onsale.onsaleapi.domains.offers.dto.UpdateOfferRequest
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.offers.mappers.CreateOfferRequestMapper
import com.onsale.onsaleapi.domains.offers.mappers.UpdateOfferRequestMapper
import com.onsale.onsaleapi.domains.offers.repositories.IOfferRepository
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OfferService(
    @Autowired val offerRepository: IOfferRepository,
    @Autowired val likeRepository: ILikeRepository,
    @Autowired val createOfferRequestMapper: CreateOfferRequestMapper,
    @Autowired val updateOfferRequestMapper: UpdateOfferRequestMapper,
) : IOfferService {
    override fun create(request: CreateOfferRequest): Offer {
        val offer = createOfferRequestMapper.transform(request)

        offerRepository.create(offer)

        return offerRepository.getById(offer.id) as Offer
    }

    override fun edit(id: ID, request: UpdateOfferRequest): Offer? {
        val offerFields = updateOfferRequestMapper.transform(request)

        offerRepository.update(id, offerFields)

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
        likeRepository.deleteAllByOfferId(offer.id)

        return offer
    }

}