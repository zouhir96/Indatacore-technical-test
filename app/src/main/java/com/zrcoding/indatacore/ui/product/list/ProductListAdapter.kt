package com.zrcoding.indatacore.ui.product.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zrcoding.indatacore.R
import com.zrcoding.indatacore.databinding.ItemProductBinding
import com.zrcoding.indatacore.ui.shared.ItemClick
import com.zrcoding.indatacore.ui.shared.Product

class ProductListAdapter(
    private val products: MutableList<Product> = mutableListOf(),
    val itemClickListener: ItemClick<Product>
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    fun refreshList(newList: List<Product>) {
        this.products.addAll(newList)
        notifyItemRangeInserted(0, newList.size)
    }

    fun getItemAt(position: Int): Product = products[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_product,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ViewHolder(
        private val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindTo(product: Product) {
            binding.product = product

            binding.root.setOnClickListener {
                itemClickListener.onItemClick(product)
            }
        }
    }
}