package com.onsale.onsaleapi.domains.likes.services

import com.onsale.onsaleapi.domains.likes.dto.CreateLikeRequest
import com.onsale.onsaleapi.domains.likes.entities.Like
import com.onsale.onsaleapi.domains.likes.mappers.CreateLikeRequestMapper
import com.onsale.onsaleapi.domains.likes.mappers.CreateLikeRequestMapperAdditionalParams
import com.onsale.onsaleapi.domains.likes.repositories.ILikeRepository
import com.onsale.onsaleapi.domains.shared.services.IUUIDService
import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LikeService(
        @Autowired private val uuidService: IUUIDService,
        @Autowired val createLikeRequestMapper: CreateLikeRequestMapper,
        @Autowired val likeRepository: ILikeRepository
) : ILikeService {
    override fun getById(id: ID): Like? {
        return likeRepository.getById(id)
    }

    override fun create(request: CreateLikeRequest): Like {
        val id = uuidService.getUUID()
        val rawLike = createLikeRequestMapper.transform(request, CreateLikeRequestMapperAdditionalParams(id))

        likeRepository.create(rawLike)

        return likeRepository.getById(id) as Like
    }
}