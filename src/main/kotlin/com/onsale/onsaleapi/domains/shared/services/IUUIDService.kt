package com.onsale.onsaleapi.domains.shared.services

import com.onsale.onsaleapi.domains.shared.types.ID

interface IUUIDService {
    fun getUUID(): ID
}