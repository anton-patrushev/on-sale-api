package com.onsale.onsaleapi.domains.likes.dto

import com.onsale.onsaleapi.domains.employees.dto.GetEmployeeByIdResponseData
import com.onsale.onsaleapi.domains.offers.dto.GetByIdOfferResponseData
import com.onsale.onsaleapi.domains.shared.types.ID

data class GetLikeByIdResponseData(
    val id: ID,
    val offer: GetByIdOfferResponseData,
    val employee: GetEmployeeByIdResponseData
)

data class GetLikeByIdResponse(
    val data: GetLikeByIdResponseData
)
