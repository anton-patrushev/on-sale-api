package com.onsale.onsaleapi.domains.offers.services

import com.onsale.onsaleapi.domains.offers.dto.CreateOfferRequest
import com.onsale.onsaleapi.domains.offers.dto.UpdateOfferRequest
import com.onsale.onsaleapi.domains.offers.entities.Offer
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
        @Autowired val createOfferRequestMapper: CreateOfferRequestMapper,
        @Autowired val updateOfferRequestMapper: UpdateOfferRequestMapper,
) : IOfferJoinedService {
    override fun create(request: CreateOfferRequest): OfferJoined {
        val offer = createOfferRequestMapper.transform(request)

        offerRepository.create(offer)

        return offerRepository.getById(offer.id) as OfferJoined
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
        offerRepository.deleteById(id)

        return offerRepository.getByIdJoined(id)
    }

}