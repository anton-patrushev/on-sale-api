package com.onsale.onsaleapi.domains.offers.mappers.common

import com.onsale.onsaleapi.domains.cities.entities.City
import com.onsale.onsaleapi.domains.companies.entities.Company

data class OfferResponseMapperAdditionalParams(
        val company: Company,
        val city: City
)
