package com.onsale.onsaleapi.domains.likes.db

import com.onsale.onsaleapi.domains.employees.entities.Employee
import com.onsale.onsaleapi.domains.employees.entities.fromDBRow
import com.onsale.onsaleapi.domains.likes.entities.Like
import com.onsale.onsaleapi.domains.likes.entities.RawLike
import com.onsale.onsaleapi.domains.offers.db.fromDBRow
import com.onsale.onsaleapi.domains.offers.entities.OfferJoined
import org.jetbrains.exposed.sql.ResultRow

fun RawLike.Companion.fromDBRow(row: ResultRow): RawLike {
    return RawLike(
        row[LikesTable.id].toString(),
        row[LikesTable.offerId].toString(),
        row[LikesTable.employeeId].toString(),
    )
}

fun Like.Companion.fromDBRow(row: ResultRow): Like {
    return Like(
            row[LikesTable.id].toString(),
            offer = OfferJoined.fromDBRow(row),
            employee = Employee.fromDBRow(row)
    )
}