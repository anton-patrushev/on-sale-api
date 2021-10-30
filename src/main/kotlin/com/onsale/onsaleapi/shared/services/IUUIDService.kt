package com.onsale.onsaleapi.shared.services

import com.onsale.onsaleapi.shared.types.ID

interface IUUIDService {
    fun getUUID(): ID
}