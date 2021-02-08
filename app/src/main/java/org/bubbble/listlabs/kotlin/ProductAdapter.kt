package org.bubbble.listlabs.kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.bubbble.listlabs.R
import org.bubbble.listlabs.databinding.ItemProductBinding
import org.bubbble.listlabs.databinding.ItemProductCategoryBinding


/**
 * @author Andrew
 * @date 2021/02/07 13:10
 */
internal class ProductAdapter : ListAdapter<ProductItem, ViewHolder>(ProductDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            R.layout.item_product_category -> ViewHolder.CategoryViewHolder(
                    ItemProductCategoryBinding.inflate(layoutInflater, parent, false))

            R.layout.item_product -> ViewHolder.ProductViewHolder(
                    ItemProductBinding.inflate(layoutInflater, parent, false))

            else -> throw IllegalArgumentException("Invalid viewType")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ViewHolder.CategoryViewHolder) {
            holder.onBind(getItem(position))
        }
        if (holder is ViewHolder.ProductViewHolder) {
            holder.onBind(getItem(position))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).type) {
            ItemCategory.TITLE -> R.layout.item_product_category
            ItemCategory.PRODUCT -> R.layout.item_product
        }
    }
}

internal sealed class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    class CategoryViewHolder(private val binding: ItemProductCategoryBinding) : ViewHolder(binding.root) {
        fun onBind(data: ProductItem) {
            binding.title.text = data.categoryTitle
        }
    }

    class ProductViewHolder(private val binding: ItemProductBinding) : ViewHolder(binding.root) {
        fun onBind(data: ProductItem) {
            Glide.with(binding.productImage).load(data.productImage).into(binding.productImage)
            binding.productName.text = data.productName
        }
    }
}

object ProductDiffCallback : DiffUtil.ItemCallback<ProductItem>() {
    override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
        return oldItem != newItem
    }

    override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
        return oldItem != newItem
    }
}