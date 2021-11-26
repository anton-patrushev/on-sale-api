package com.onsale.onsaleapi.domains.likes.services

import com.onsale.onsaleapi.domains.likes.dto.CreateLikeRequest
import com.onsale.onsaleapi.domains.likes.entities.Like
import com.onsale.onsaleapi.domains.likes.entities.RawLike
import com.onsale.onsaleapi.domains.shared.types.ID

interface ILikeService {
    fun getById(id: ID): Like?
    fun create(request: CreateLikeRequest): Like
    fun getAll(): List<Like>
}