package org.bubbble.listlabs.java;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.bubbble.listlabs.databinding.ItemProductBinding;
import org.bubbble.listlabs.databinding.ItemProductCategoryBinding;

/**
 * @author Andrew
 * @date 2021/02/08 12:14
 */
public class ProductAdapter extends ListAdapter<ProductItem, RecyclerView.ViewHolder> {

    protected ProductAdapter() {
        super(new ProductDiffCallback());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case 0: return new CategoryViewHolder(
                    ItemProductCategoryBinding.inflate(layoutInflater, parent, false)
            );

            case 1: return new ProductViewHolder(
                    ItemProductBinding.inflate(layoutInflater, parent, false)
            );

            default: throw new IllegalArgumentException("Invalid viewType");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CategoryViewHolder) {
            ((CategoryViewHolder) holder).onBind(getItem(position));
        }

        if (holder instanceof ProductViewHolder) {
            ((ProductViewHolder) holder).onBind(getItem(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (getItem(position).getType()) {
            case TITLE: return 0;
            case PRODUCT: return 1;
            default: return -1;
        }
    }
}

class CategoryViewHolder extends RecyclerView.ViewHolder {

    private final ItemProductCategoryBinding binding;

    public CategoryViewHolder(@NonNull ItemProductCategoryBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void onBind(ProductItem data) {
        binding.title.setText(data.getCategoryTitle());
    }
}


class ProductViewHolder extends RecyclerView.ViewHolder {

    private final ItemProductBinding binding;

    public ProductViewHolder(@NonNull ItemProductBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void onBind(ProductItem data) {
        Glide.with(binding.productImage).load(data.getProductImage()).into(binding.productImage);
        binding.productName.setText(data.getProductName());
    }
}

class ProductDiffCallback extends DiffUtil.ItemCallback<ProductItem> {

    @Override
    public boolean areItemsTheSame(@NonNull ProductItem oldItem, @NonNull ProductItem newItem) {
        return oldItem == newItem;
    }

    @Override
    public boolean areContentsTheSame(@NonNull ProductItem oldItem, @NonNull ProductItem newItem) {
        return oldItem.getProductName().equals(newItem.getProductName())
                && oldItem.getProductImage() == ( newItem.getProductImage())
                && oldItem.getCategoryTitle().equals(newItem.getCategoryTitle())
                && oldItem.getType().equals( newItem.getType());
    }
}
