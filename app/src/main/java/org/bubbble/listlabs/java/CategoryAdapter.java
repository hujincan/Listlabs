package org.bubbble.listlabs.java;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import org.bubbble.listlabs.R;
import org.bubbble.listlabs.databinding.ItemMenuCategoryBinding;

/**
 * @author Andrew
 * @date 2021/02/08 12:14
 */

interface CategorySelected {
    void selected(int position);
}

interface CategoryClick {
    void onClick(int position);
}

interface CategorySelectedItem {
    boolean onSelectedItem(int position);
}

public class CategoryAdapter extends ListAdapter<CategoryItem, ViewHolder>
        implements CategoryClick, CategorySelectedItem {

    private final CategorySelected onSelected;

    protected CategoryAdapter(CategorySelected onSelected) {
        super(new CategoryDiffCallback());
        this.onSelected = onSelected;
    }


    private int currentItem = 0;

    public int getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(int currentItem) {
        this.currentItem = currentItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemMenuCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(getItem(position), this, this);
    }

    @Override
    public void onClick(int position) {
        currentItem = position;
        onSelected.selected(position);
        notifyDataSetChanged();
    }

    @Override
    public boolean onSelectedItem(int position) {
        return currentItem == position;
    }

    public void currentCategory(String category) {
        for (int index = 0; index < getCurrentList().size(); index++) {
            if (category.equals(getCurrentList().get(index).getCategoryTitle())) {
                currentItem = index;
                notifyDataSetChanged();
                break;
            }
        }
    }
}

class CategoryDiffCallback extends DiffUtil.ItemCallback<CategoryItem> {

    @Override
    public boolean areItemsTheSame(@NonNull CategoryItem oldItem, @NonNull CategoryItem newItem) {
        return oldItem == newItem;
    }

    @Override
    public boolean areContentsTheSame(@NonNull CategoryItem oldItem, @NonNull CategoryItem newItem) {
        return oldItem.getCategoryTitle().equals(newItem.getCategoryTitle());
    }
}


class ViewHolder extends RecyclerView.ViewHolder {

    private final ItemMenuCategoryBinding binding;

    public ViewHolder(@NonNull ItemMenuCategoryBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void onBind(CategoryItem data,
                CategoryClick categoryClick,
                CategorySelectedItem categorySelectedItem) {
        binding.title.setText(data.getCategoryTitle());
        binding.title.setOnClickListener(v -> {
            categoryClick.onClick(getAdapterPosition());
        });

        binding.title.setBackgroundColor(
                categorySelectedItem.onSelectedItem(getAdapterPosition())
                        ? ContextCompat.getColor(binding.getRoot().getContext(), R.color.white)
                        : ContextCompat.getColor(binding.getRoot().getContext(), R.color.unselect));
    }

}