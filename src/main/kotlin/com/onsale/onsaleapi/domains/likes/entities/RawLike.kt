package com.onsale.onsaleapi.domains.likes.entities

import com.onsale.onsaleapi.domains.shared.types.ID

data class RawLike(
    val id: ID,
    val offerId: ID,
    val employeeId: ID
)
