import com.onsale.onsaleapi.domains.cities.controllers.ILikeController
import com.onsale.onsaleapi.domains.cities.mappers.CreateLikeResponseMapper
import com.onsale.onsaleapi.domains.likes.dto.CreateLikeRequest
import com.onsale.onsaleapi.domains.likes.dto.CreateLikeResponse
import com.onsale.onsaleapi.domains.likes.entities.Like
import com.onsale.onsaleapi.domains.offers.controllers.OfferController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping(value = [LikeController.BASE_LIKE_URL])
class LikeController(
    @Autowired val createLikeResponseMapper: CreateLikeResponseMapper
): ILikeController {
    override fun createLike(request: CreateLikeRequest): ResponseEntity<CreateLikeResponse> {
        val like = Like() as Like

        return ResponseEntity.created(URI.create("${LikeController.BASE_LIKE_URL}/${like.id}"))
            .body(createLikeResponseMapper.transform(like))
    }

    companion object {
        const val BASE_LIKE_URL = "likes/"
    }
}