package com.onsale.onsaleapi.domains.offers.services

import com.onsale.onsaleapi.domains.likes.repositories.ILikeRepository
import com.onsale.onsaleapi.domains.offers.dto.CreateOfferRequest
import com.onsale.onsaleapi.domains.offers.dto.UpdateOfferRequest
import com.onsale.onsaleapi.domains.offers.entities.OfferJoined
import com.onsale.onsaleapi.domains.offers.mappers.CreateOfferRequestMapper
import com.onsale.onsaleapi.domains.offers.mappers.UpdateOfferRequestMapper
import com.onsale.onsaleapi.domains.offers.repositories.IOfferRepository
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OfferJoinedService(
    @Autowired val offerRepository: IOfferRepository,
    @Autowired val likeRepository: ILikeRepository,
    @Autowired val createOfferRequestMapper: CreateOfferRequestMapper,
    @Autowired val updateOfferRequestMapper: UpdateOfferRequestMapper,
) : IOfferJoinedService {
    override fun create(request: CreateOfferRequest): OfferJoined {
        val offer = createOfferRequestMapper.transform(request)

        offerRepository.create(offer)

        return offerRepository.getByIdJoined(offer.id) as OfferJoined
    }

    override fun edit(id: ID, request: UpdateOfferRequest): OfferJoined? {
        val offerFields = updateOfferRequestMapper.transform(request)

        offerRepository.update(id, offerFields)

        return offerRepository.getByIdJoined(id)
    }

    override fun getById(id: ID): OfferJoined? {
        return offerRepository.getByIdJoined(id)
    }

    override fun getAll(): List<OfferJoined> {
        return offerRepository.getAllJoined()
    }

    override fun deleteById(id: ID): OfferJoined? {
        val offer = offerRepository.getByIdJoined(id) ?: return null

        offerRepository.deleteById(offer.id)
        likeRepository.deleteAllByOfferId(offer.id)

        return offer
    }

}