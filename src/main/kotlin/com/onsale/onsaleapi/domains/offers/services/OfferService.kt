package com.onsale.onsaleapi.domains.offers.services

import com.onsale.onsaleapi.domains.offers.dto.CreateOfferRequest
import com.onsale.onsaleapi.domains.offers.dto.UpdateOfferRequest
import com.onsale.onsaleapi.domains.offers.entities.Offer
import com.onsale.onsaleapi.domains.offers.repositories.IOfferRepository
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OfferService(
        @Autowired val offerRepository: IOfferRepository
) : IOfferService {
    override fun create(request: CreateOfferRequest): Offer {
        TODO("Not yet implemented")
    }

    override fun edit(id: ID, request: UpdateOfferRequest): Offer? {
        TODO("Not yet implemented")
    }

    override fun getById(id: ID): Offer? {
        return offerRepository.getById(id)
    }

    override fun getAll(): List<Offer> {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: ID): Offer? {
        TODO("Not yet implemented")
    }

}