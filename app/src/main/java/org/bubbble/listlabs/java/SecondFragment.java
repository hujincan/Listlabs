package org.bubbble.listlabs.java;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.bubbble.listlabs.R;
import org.bubbble.listlabs.databinding.FragmentSecondBinding;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    private final Handler handler = new Handler(Looper.getMainLooper());

    private FragmentSecondBinding binding;

    private LinearLayoutManager categoryLayoutManager;
    private GridLayoutManager productLayoutManager;

    private final List<ProductItem> productData = new ArrayList<>();
    private final List<CategoryItem> categoryData = new ArrayList<>();

    // 记录产品列表的单行position
    private final List<Integer> titlePosition = new ArrayList<>();

    private CategoryAdapter categoryAdapter;
    private ProductAdapter productAdapter;

    private int currentCategory = -1;
    private int lastCategory = -1;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        categoryLayoutManager = new LinearLayoutManager(getContext());
        productLayoutManager = new GridLayoutManager(getContext(), 3);

        productAdapter = new ProductAdapter();

        RecyclerView.SmoothScroller smoothScrollerStart = new LinearSmoothScroller(getContext()) {
            @Override
            protected int getVerticalSnapPreference() {
                return SNAP_TO_START;
            }
        };

        categoryAdapter = new CategoryAdapter(position -> {
            if (position < titlePosition.size()) {
                smoothScrollerStart.setTargetPosition(titlePosition.get(position));
                productLayoutManager.startSmoothScroll(smoothScrollerStart);
                currentCategory = position;
            }
        });

        binding.categoryList.setLayoutManager(categoryLayoutManager);
        binding.categoryList.setAdapter(categoryAdapter);
        binding.productList.setLayoutManager(productLayoutManager);
        binding.productList.setAdapter(productAdapter);

        setupData();
    }

    private void setupData() {
        new Thread(() -> {
            categoryData.clear();
            categoryData.add(new CategoryItem("直线运动零件"));
            categoryData.add(new CategoryItem("轴承/凸轮轴承随动器/旋转零件"));
            categoryData.add(new CategoryItem("连结连结机构部件"));
            categoryData.add(new CategoryItem("联轴器/带轮/传动"));
            categoryData.add(new CategoryItem("马达/减速器/离合器制动机"));
            categoryData.add(new CategoryItem("传送机/滚轮/传送零件"));
            categoryData.add(new CategoryItem("定位/固定零件"));
            categoryData.add(new CategoryItem("滑台/光学部品/检查用部品"));
            categoryData.add(new CategoryItem("传感器/开关"));
            categoryData.add(new CategoryItem("气动/液压设备"));
            categoryData.add(new CategoryItem("真空零件"));
            categoryData.add(new CategoryItem("液压用装置"));
            categoryData.add(new CategoryItem("涂装设备"));
            categoryData.add(new CategoryItem("配管零件"));

            handler.post(() -> {
                categoryAdapter.submitList(categoryData);
            });

        }).start();

        new Thread(() -> {
            titlePosition.clear();
            productData.clear();

            productData.add(new ProductItem(null, null, "直线运动零件", ItemCategory.TITLE));
            titlePosition.add(productData.size() - 1);

            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT));

            productData.add(new ProductItem(null, null, "轴承/凸轮轴承随动器/旋转零件", ItemCategory.TITLE));
            titlePosition.add(productData.size() - 1);

            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "轴承/凸轮轴承随动器/旋转零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "轴承/凸轮轴承随动器/旋转零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "轴承/凸轮轴承随动器/旋转零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "轴承/凸轮轴承随动器/旋转零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "轴承/凸轮轴承随动器/旋转零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "轴承/凸轮轴承随动器/旋转零件", ItemCategory.PRODUCT));

            productData.add(new ProductItem(null, null, "连结连结机构部件", ItemCategory.TITLE));
            titlePosition.add(productData.size() - 1);

            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "连结连结机构部件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "连结连结机构部件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "连结连结机构部件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "连结连结机构部件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "连结连结机构部件", ItemCategory.PRODUCT));

            productData.add(new ProductItem(null, null, "联轴器/带轮/传动", ItemCategory.TITLE));
            titlePosition.add(productData.size() - 1);

            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT));

            productData.add(new ProductItem(null, null, "马达/减速器/离合器制动机", ItemCategory.TITLE));
            titlePosition.add(productData.size() - 1);

            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "马达/减速器/离合器制动机", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "马达/减速器/离合器制动机", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "马达/减速器/离合器制动机", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "马达/减速器/离合器制动机", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "马达/减速器/离合器制动机", ItemCategory.PRODUCT));

            productData.add(new ProductItem(null, null, "传送机/滚轮/传送零件", ItemCategory.TITLE));
            titlePosition.add(productData.size() - 1);

            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "传送机/滚轮/传送零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "传送机/滚轮/传送零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "传送机/滚轮/传送零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "传送机/滚轮/传送零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "传送机/滚轮/传送零件", ItemCategory.PRODUCT));

            productData.add(new ProductItem(null, null, "定位/固定零件", ItemCategory.TITLE));
            titlePosition.add(productData.size() - 1);

            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT));

            productData.add(new ProductItem(null, null, "滑台/光学部品/检查用部品", ItemCategory.TITLE));
            titlePosition.add(productData.size() - 1);

            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "滑台/光学部品/检查用部品", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "滑台/光学部品/检查用部品", ItemCategory.PRODUCT));

            productData.add(new ProductItem(null, null, "传感器/开关", ItemCategory.TITLE));
            titlePosition.add(productData.size() - 1);

            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "传感器/开关", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "传感器/开关", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "传感器/开关", ItemCategory.PRODUCT));

            productData.add(new ProductItem(null, null, "气动/液压设备", ItemCategory.TITLE));
            titlePosition.add(productData.size() - 1);

            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "气动/液压设备", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "气动/液压设备", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "气动/液压设备", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "气动/液压设备", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "气动/液压设备", ItemCategory.PRODUCT));

            productData.add(new ProductItem(null, null, "真空零件", ItemCategory.TITLE));
            titlePosition.add(productData.size() - 1);

            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "真空零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "真空零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "真空零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "真空零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "真空零件", ItemCategory.PRODUCT));

            productData.add(new ProductItem(null, null, "液压用装置", ItemCategory.TITLE));
            titlePosition.add(productData.size() - 1);

            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "液压用装置", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "液压用装置", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "液压用装置", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "液压用装置", ItemCategory.PRODUCT));

            productData.add(new ProductItem(null, null, "涂装设备", ItemCategory.TITLE));
            titlePosition.add(productData.size() - 1);

            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "涂装设备", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "涂装设备", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "涂装设备", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "涂装设备", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "涂装设备", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "涂装设备", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "涂装设备", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "涂装设备", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "涂装设备", ItemCategory.PRODUCT));

            productData.add(new ProductItem(null, null, "配管零件", ItemCategory.TITLE));
            titlePosition.add(productData.size() - 1);

            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "配管零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "配管零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "配管零件", ItemCategory.PRODUCT));
            productData.add(new ProductItem("产品名", R.drawable.ic_snapseed, "配管零件", ItemCategory.PRODUCT));


            handler.post(() -> {
                productAdapter.submitList(productData);

                productLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        return titlePosition.contains(position) ? 3 : 1;
                    }
                });

                CenterSmoothScroller smoothScrollerCenter = new CenterSmoothScroller(getContext());

                binding.productList.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);

                        if (newState == RecyclerView.SCROLL_STATE_DRAGGING || newState == RecyclerView.SCROLL_STATE_IDLE) {
                            currentCategory = -1;
                        }
                    }

                    @Override
                    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);

                        if (currentCategory != categoryAdapter.getCurrentItem()) {
                            int last = productLayoutManager.findLastCompletelyVisibleItemPosition();
                            String categoryTitle = productData.get(last).getCategoryTitle();
                            if (last > productData.size() - 4 && categoryTitle != null) {
                                if (categoryTitle.equals(categoryData.get(categoryData.size() - 1).getCategoryTitle())) {
                                    categoryAdapter.currentCategory(categoryTitle);
                                    smoothScrollerCenter.setTargetPosition(categoryAdapter.getCurrentItem());
                                    categoryLayoutManager.startSmoothScroll(smoothScrollerCenter);
                                    return;
                                }
                            }

                            // 上方完全显示的item的类别
                            String topCategory = productData.get(productLayoutManager.findFirstCompletelyVisibleItemPosition()).getCategoryTitle();
                            if (topCategory != null) {
                                categoryAdapter.currentCategory(topCategory);
                            }

                            if (lastCategory != categoryAdapter.getCurrentItem()) {
                                smoothScrollerCenter.setTargetPosition(categoryAdapter.getCurrentItem());
                                categoryLayoutManager.startSmoothScroll(smoothScrollerCenter);
                                lastCategory = categoryAdapter.getCurrentItem();
                            }
                        }

                    }
                });
            });
        }).start();
    }
}