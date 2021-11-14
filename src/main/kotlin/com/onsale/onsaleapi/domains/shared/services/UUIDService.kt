package com.onsale.onsaleapi.domains.shared.services

import com.onsale.onsaleapi.domains.shared.types.ID
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UUIDService: IUUIDService {
    override fun getUUID(): ID {
        return UUID.randomUUID().toString()
    }
}