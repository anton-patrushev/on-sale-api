package com.onsale.onsaleapi.core.db

import org.jetbrains.exposed.sql.Database
import org.springframework.stereotype.Component

@Component
class DBManager {
    companion object : IDBManager {
        override fun createConnection() {
            Database.connect(DB_URL, driver = "org.postgresql.Driver", user = DB_USER, password = DB_PASSWORD)
        }

        // TODO: move url, password, user into env configs
        private const val DB_NAME = "onsale"
        private const val DB_PORT = "5432"
        private const val DB_USER = "admin"
        private const val DB_PASSWORD = "password"
        private const val DB_URL = "jdbc:postgresql://localhost:${DB_PORT}/${DB_NAME}"
    }
}