package com.onsale.onsaleapi.domains.likes.controllers

import com.onsale.onsaleapi.domains.likes.dto.CreateLikeRequest
import com.onsale.onsaleapi.domains.likes.dto.CreateLikeResponse
import com.onsale.onsaleapi.domains.likes.dto.GetLikeByIdResponse
import com.onsale.onsaleapi.domains.likes.dto.GetLikesResponse
import com.onsale.onsaleapi.domains.likes.mappers.CreateLikeResponseMapper
import com.onsale.onsaleapi.domains.likes.mappers.GetLikeByIdResponseMapper
import com.onsale.onsaleapi.domains.likes.mappers.GetLikesResponseMapper
import com.onsale.onsaleapi.domains.likes.services.ILikeService
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [LikeController.BASE_LIKE_URL])
class LikeController(
    @Autowired val likeService: ILikeService,
    @Autowired val createLikeResponseMapper: CreateLikeResponseMapper,
    @Autowired val getLikeByIdResponseMapper: GetLikeByIdResponseMapper,
    @Autowired val getLikesResponseMapper: GetLikesResponseMapper
) : ILikeController {
    @PostMapping
    override fun createLike(request: CreateLikeRequest): ResponseEntity<CreateLikeResponse> {
        val like = likeService.create(request)

        return ResponseEntity.created(URI.create("${BASE_LIKE_URL}/${like.id}"))
            .body(createLikeResponseMapper.transform(like))
    }

    @GetMapping("/{id}")
    override fun getLikeById(@PathVariable id: ID): ResponseEntity<GetLikeByIdResponse> {
        val like = likeService.getById(id) ?: return ResponseEntity.notFound().build()

        return ResponseEntity.created(URI.create("${BASE_LIKE_URL}/${like.id}"))
            .body(getLikeByIdResponseMapper.transform(like))
    }

    @GetMapping
    override fun getLikes(): ResponseEntity<GetLikesResponse> {
        val likes = likeService.getAll()

        return ResponseEntity.ok(getLikesResponseMapper.transform(likes))
    }

    companion object {
        const val BASE_LIKE_URL = "likes/"
    }
}