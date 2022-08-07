package com.zrcoding.indatacore.data.repository

import com.zrcoding.indatacore.core.Resource
import com.zrcoding.indatacore.ui.shared.Cart
import com.zrcoding.indatacore.ui.shared.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProducts(): Flow<Resource<List<Product>>>

    fun getProduct(id: String): Flow<Resource<Product>>

    fun buyProduct(cart: Cart)
}