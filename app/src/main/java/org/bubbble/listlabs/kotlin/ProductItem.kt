package org.bubbble.listlabs.kotlin

/**
 * @author Andrew
 * @date 2021/02/07 13:11
 */
data class ProductItem (
    val productName: String?,
    val productImage: Int?,
    val categoryTitle: String?,
    val type: ItemCategory
)

enum class ItemCategory{
    TITLE,
    PRODUCT
}