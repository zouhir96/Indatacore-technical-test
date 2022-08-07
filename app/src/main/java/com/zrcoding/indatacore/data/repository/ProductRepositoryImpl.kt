package com.zrcoding.indatacore.data.repository

import com.zrcoding.indatacore.core.Resource
import com.zrcoding.indatacore.data.sources.fake.FakeDataSource
import com.zrcoding.indatacore.ui.shared.Cart
import com.zrcoding.indatacore.ui.shared.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val fakeDataSource: FakeDataSource // todo replace by local and remote data sources
) : ProductRepository {
    override fun getProducts(): Flow<Resource<List<Product>>> = flow {
        // todo replace by: fetching products from remote and update local then emit from local
        emit(Resource.Success(fakeDataSource.getProducts()))
    }

    override fun getProduct(id: String): Flow<Resource<Product>> = flow {
        // todo replace by: fetching products from remote and update local then emit from local
        fakeDataSource.getProducts().find {
            it.id == id
        }?.let {
            emit(Resource.Success(it))
        }
    }

    override fun buyProduct(cart: Cart) {
        TODO("Not yet implemented")
    }
}