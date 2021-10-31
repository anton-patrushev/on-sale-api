package com.onsale.onsaleapi.core.bootstrap

import com.onsale.onsaleapi.core.db.DBManager
import org.springframework.stereotype.Component

@Component
class Bootstrap {
    companion object {
        fun initApp() {
            // TODO("Initialize all app resources, e.g. db")
            DBManager.createConnection()
        }
    }
}