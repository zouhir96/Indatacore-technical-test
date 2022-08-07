package com.zrcoding.indatacore.ui.shared

data class Cart(
    val products: MutableList<Product> = mutableListOf(),
    val discount: Double = 0.0 // may be added later
) {
    fun isEmpty(): Boolean = products.isEmpty()

    fun addProduct(product: Product) = products.find {
        it.id == product.id
    }?.quantity?.plus(1) ?: kotlin.run {
        product.quantity = 1
        products.add(product)
    }

    fun removeProduct(product: Product) = products.removeAll { product.id == it.id }

    fun getTotalPrice(): Double = products.sumOf { it.price }

    fun getProductCount(): Int = products.sumOf { it.quantity }
}
