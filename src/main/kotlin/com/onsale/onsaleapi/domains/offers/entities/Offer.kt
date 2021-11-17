package com.onsale.onsaleapi.domains.offers.entities

import com.onsale.onsaleapi.domains.shared.types.ID

//data class OfferCompanyInfo(
//        val id: ID,
//        val name: String,
//        val websiteURL: String?,
//        val phone: String?,
//        val workingSchedule: String?
//)
//
//data class OfferCityInfo(
//        val id: ID,
//        val name: String
//)

data class Offer(
        val id: ID,
        val companyId: ID,
        val description: String?,
        val sale: String?,
        val cityId: ID,
        val created_at: String, // TODO: Date type
) {
    companion object {}
}

