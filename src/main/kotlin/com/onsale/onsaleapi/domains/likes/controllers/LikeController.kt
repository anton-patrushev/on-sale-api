package com.onsale.onsaleapi.domains.likes.controllers

import com.onsale.onsaleapi.domains.likes.dto.CreateLikeRequest
import com.onsale.onsaleapi.domains.likes.dto.CreateLikeResponse
import com.onsale.onsaleapi.domains.likes.mappers.CreateLikeResponseMapper
import com.onsale.onsaleapi.domains.likes.services.ILikeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping(value = [LikeController.BASE_LIKE_URL])
class LikeController(
        @Autowired val likeService: ILikeService,
        @Autowired val createLikeResponseMapper: CreateLikeResponseMapper
) : ILikeController {
    @PostMapping
    override fun createLike(request: CreateLikeRequest): ResponseEntity<CreateLikeResponse> {
        val like = likeService.create(request)

        return ResponseEntity.created(URI.create("${BASE_LIKE_URL}/${like.id}"))
                .body(createLikeResponseMapper.transform(like))
    }

    companion object {
        const val BASE_LIKE_URL = "likes/"
    }
}