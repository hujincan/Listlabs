package org.bubbble.listlabs.kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.bubbble.listlabs.R
import org.bubbble.listlabs.databinding.ItemMenuCategoryBinding

/**
 * @author Andrew
 * @date 2021/02/07 13:10
 */

class CategoryAdapter(
    private var listener: (Int) -> Unit
) : ListAdapter<CategoryItem, CategoryViewHolder>(CategoryDiffCallback) {

    var currentItem = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(ItemMenuCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.onBind(getItem(position), ::onClick, ::isSelected)
    }

    fun currentCategory(category: String) {
        for ((index, value) in currentList.withIndex()) {
            if (category == value.categoryTitle) {
                currentItem = index
                notifyDataSetChanged()
                break
            }
        }
    }

    private fun onClick(position: Int) {
        currentItem = position
        listener(position)
        notifyDataSetChanged()
    }


    private fun isSelected(position: Int): Boolean {
        return currentItem == position
    }
}

class CategoryViewHolder(
        private val binding: ItemMenuCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: CategoryItem,
               onClick: (Int) -> Unit,
               isSelected: (Int) -> Boolean) {
        binding.title.text = data.categoryTitle
        binding.title.setOnClickListener {
            onClick(adapterPosition)
        }

        binding.title.setBackgroundColor(
            if (isSelected(adapterPosition)) {
                ContextCompat.getColor(binding.root.context, R.color.white)
            } else {
                ContextCompat.getColor(binding.root.context, R.color.unselect)
            }
        )
    }
}
object CategoryDiffCallback : DiffUtil.ItemCallback<CategoryItem>() {
    override fun areItemsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
        return oldItem == newItem
    }
}
