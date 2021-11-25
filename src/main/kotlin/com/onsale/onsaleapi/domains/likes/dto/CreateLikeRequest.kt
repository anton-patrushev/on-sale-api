package com.onsale.onsaleapi.domains.likes.dto

import com.onsale.onsaleapi.domains.shared.types.ID

data class CreateLikeRequest(
    val offer_id: ID,
    val employee_id: ID
)
