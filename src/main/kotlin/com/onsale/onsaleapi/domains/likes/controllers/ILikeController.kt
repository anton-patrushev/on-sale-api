package com.onsale.onsaleapi.domains.likes.controllers

import com.onsale.onsaleapi.domains.likes.dto.CreateLikeRequest
import com.onsale.onsaleapi.domains.likes.dto.CreateLikeResponse
import com.onsale.onsaleapi.domains.likes.dto.GetLikeByIdResponse
import com.onsale.onsaleapi.domains.likes.dto.GetLikesResponse
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.http.ResponseEntity

interface ILikeController {
    fun createLike(request: CreateLikeRequest): ResponseEntity<CreateLikeResponse>
    fun getLikeById(id: ID): ResponseEntity<GetLikeByIdResponse>
    fun getLikes(): ResponseEntity<GetLikesResponse>
}