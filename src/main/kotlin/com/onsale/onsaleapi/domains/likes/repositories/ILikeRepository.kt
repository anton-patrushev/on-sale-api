package com.onsale.onsaleapi.domains.likes.repositories

import com.onsale.onsaleapi.domains.likes.entities.Like
import com.onsale.onsaleapi.domains.likes.entities.RawLike
import com.onsale.onsaleapi.domains.shared.types.ID

interface ILikeRepository {
    fun getById(id: ID): Like?
    fun create(like: RawLike)
    fun getAll(): List<Like>
    fun delete(id: ID)
    fun deleteAllByEmployeeId(employeeId: ID)
    fun deleteAllByOfferId(offerId: ID)
}