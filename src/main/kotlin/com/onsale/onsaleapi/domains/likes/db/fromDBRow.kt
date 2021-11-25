package com.onsale.onsaleapi.domains.likes.db

import com.onsale.onsaleapi.domains.cities.db.LikesTable
import com.onsale.onsaleapi.domains.likes.entities.Like
import org.jetbrains.exposed.sql.ResultRow

fun Like.Companion.fromDBRow(row: ResultRow): Like {
    return Like(
        row[LikesTable.id].toString(),
        row[LikesTable.offerId].toString(),
        row[LikesTable.employeeId].toString(),
    )
}