package com.zrcoding.indatacore.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zrcoding.indatacore.R
import com.zrcoding.indatacore.databinding.ItemCartProductBinding
import com.zrcoding.indatacore.ui.shared.Product

class CartProductAdapter(
    private val products: MutableList<Product> = mutableListOf(),
    val listener: CartProductAdapterListener
) : RecyclerView.Adapter<CartProductAdapter.ViewHolder>() {

    fun refreshList(newList: List<Product>) {
        this.products.clear()
        this.products.addAll(newList)
        notifyItemRangeInserted(0, newList.size)
    }

    fun removeItem(product: Product) {
        val position = this.products.indexOf(product)
        this.products.remove(product)
        if (this.products.isEmpty()) {
            listener.onCartCleared()
        } else {
            notifyItemRemoved(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_cart_product,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindTo(
        products[position]
    )

    override fun getItemCount(): Int = products.size

    inner class ViewHolder(
        private val binding: ItemCartProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindTo(product: Product) {
            binding.product = product

            binding.detailsBtn.setOnClickListener { listener.onDetailsClicked(product) }
            binding.removeFromCartBtn.setOnClickListener { listener.onRemoveClicked(product) }
        }
    }
}