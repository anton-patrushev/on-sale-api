package com.onsale.onsaleapi.domains.likes.controllers

import com.onsale.onsaleapi.domains.likes.dto.*
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.http.ResponseEntity

interface ILikeController {
    fun createLike(request: CreateLikeRequest): ResponseEntity<CreateLikeResponse>
    fun getLikeById(id: ID): ResponseEntity<GetLikeByIdResponse>
    fun getLikes(): ResponseEntity<GetLikesResponse>
    fun deleteLike(id: ID): ResponseEntity<DeleteLikeResponse>
}