package com.onsale.onsaleapi.domains.categories.repositories

import com.onsale.onsaleapi.domains.categories.db.CategoriesTable
import com.onsale.onsaleapi.domains.categories.db.fromDBRow
import com.onsale.onsaleapi.domains.categories.entities.OfferCategory
import com.onsale.onsaleapi.domains.categories.entities.OfferCategoryFields
import com.onsale.onsaleapi.domains.shared.types.ID
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class CategoryRepository : ICategoryRepository {
    override fun getById(id: ID): OfferCategory? {
        val query = transaction {
            CategoriesTable.select { CategoriesTable.id eq UUID.fromString(id) }.firstOrNull()
        } ?: return null

        return OfferCategory.fromDBRow(query)
    }

    override fun getAll(): List<OfferCategory> {
        val query = transaction {
            CategoriesTable.selectAll().map { it }
        }

        return query.map(OfferCategory.Companion::fromDBRow)
    }

    override fun create(category: OfferCategory) {
        transaction {
            CategoriesTable.insert {
                it[id] = UUID.fromString(category.id)
                it[name] = category.name
            }
        }
    }

    override fun update(id:ID, categoryFields: OfferCategoryFields) {
        transaction {
            CategoriesTable.update({ CategoriesTable.id eq UUID.fromString(id) }) {
                if (categoryFields.name != null) it[name] = categoryFields.name
            }
        }
    }

    override fun deleteById(id: ID) {
        transaction {
            CategoriesTable.deleteWhere { CategoriesTable.id eq UUID.fromString(id) }
        }
    }

    override fun deleteAll() {
        transaction {
            CategoriesTable.deleteAll()
        }
    }
}