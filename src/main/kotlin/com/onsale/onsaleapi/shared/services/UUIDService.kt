package com.onsale.onsaleapi.shared.services

import com.onsale.onsaleapi.shared.types.ID
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UUIDService: IUUIDService {
    override fun getUUID(): ID {
        return UUID.randomUUID().toString()
    }
}