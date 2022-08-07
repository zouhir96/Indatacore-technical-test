package com.zrcoding.indatacore.ui.product.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zrcoding.indatacore.core.Resource
import com.zrcoding.indatacore.data.repository.ProductRepository
import com.zrcoding.indatacore.ui.shared.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _productList: MutableStateFlow<List<Product>> = MutableStateFlow(emptyList())
    val productList: StateFlow<List<Product>> = _productList

    init {
        viewModelScope.launch {
            productRepository.getProducts().collect {
                when (it) {
                    is Resource.Loading -> {
                        // todo add loading (need design)
                    }
                    is Resource.Success -> _productList.emit(it.data)
                    is Resource.Error -> {
                        // todo add error handle (need design)
                    }
                }
            }
        }
    }
}