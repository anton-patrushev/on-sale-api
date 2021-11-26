package com.onsale.onsaleapi.domains.likes.repositories

import com.onsale.onsaleapi.domains.cities.db.CitiesTable
import com.onsale.onsaleapi.domains.companies.db.CompaniesTable
import com.onsale.onsaleapi.domains.employees.db.EmployeesTable
import com.onsale.onsaleapi.domains.likes.db.LikesTable
import com.onsale.onsaleapi.domains.likes.db.fromDBRow
import com.onsale.onsaleapi.domains.likes.entities.Like
import com.onsale.onsaleapi.domains.likes.entities.RawLike
import com.onsale.onsaleapi.domains.offers.db.OffersTable
import com.onsale.onsaleapi.domains.shared.types.ID
import org.jetbrains.exposed.sql.ColumnSet
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class LikeRepository : ILikeRepository {

    fun getJoinedOffers(): ColumnSet = OffersTable.leftJoin(CitiesTable).leftJoin(CompaniesTable)

    override fun getById(id: ID): Like? {
        val like = transaction {
            LikesTable.leftJoin(getJoinedOffers())
                .leftJoin(EmployeesTable)
                .select { LikesTable.id eq UUID.fromString(id) }.firstOrNull()
        } ?: return null

        return Like.fromDBRow(like)
    }

    override fun create(like: RawLike) {
        transaction {
            LikesTable.insert {
                it[id] = UUID.fromString(like.id)
                it[offerId] = UUID.fromString(like.offerId)
                it[employeeId] = UUID.fromString(like.employeeId)
            }
        }
    }

    override fun getAll(): List<Like> {
        val likesQuery = transaction {
            LikesTable.leftJoin(getJoinedOffers())
                .leftJoin(EmployeesTable)
                .selectAll().map { it }
        }

        return likesQuery.map(Like.Companion::fromDBRow)
    }
}