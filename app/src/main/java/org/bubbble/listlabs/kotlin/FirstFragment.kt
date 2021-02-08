package org.bubbble.listlabs.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SmoothScroller
import org.bubbble.listlabs.R
import org.bubbble.listlabs.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    private lateinit var categoryLayoutManager: LinearLayoutManager
    private lateinit var productLayoutManager: GridLayoutManager

    val titlePosition = ArrayList<Int>()

    private lateinit var categoryAdapter: CategoryAdapter
    private val productAdapter: ProductAdapter by lazy {
        ProductAdapter()
    }

    private val productData = mutableListOf<ProductItem>()
    private val categoryData = mutableListOf<CategoryItem>()

    private var currentCategory = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryLayoutManager = LinearLayoutManager(context)
        productLayoutManager = GridLayoutManager(context, 3)

        val smoothScrollerStart: SmoothScroller = object : LinearSmoothScroller(context) {
            override fun getVerticalSnapPreference(): Int {
                return SNAP_TO_START
            }
        }

        categoryAdapter = CategoryAdapter {

            if (it < titlePosition.size) {
                smoothScrollerStart.targetPosition = titlePosition[it]
                productLayoutManager.startSmoothScroll(smoothScrollerStart)
                currentCategory = it
            }
        }

        binding.apply {
            categoryList.layoutManager = categoryLayoutManager
            categoryList.adapter = categoryAdapter
            productList.layoutManager = productLayoutManager
            productList.adapter = productAdapter
        }

        setupData()
    }

    private fun setupData() {

        doAsync {
            categoryData.clear()
            categoryData.apply {
                add(CategoryItem("直线运动零件"))
                add(CategoryItem("轴承/凸轮轴承随动器/旋转零件"))
                add(CategoryItem("连结连结机构部件"))
                add(CategoryItem("联轴器/带轮/传动"))
                add(CategoryItem("马达/减速器/离合器制动机"))
                add(CategoryItem("传送机/滚轮/传送零件"))
                add(CategoryItem("定位/固定零件"))
                add(CategoryItem("滑台/光学部品/检查用部品"))
                add(CategoryItem("传感器/开关"))
                add(CategoryItem("气动/液压设备"))
                add(CategoryItem("真空零件"))
                add(CategoryItem("液压用装置"))
                add(CategoryItem("涂装设备"))
                add(CategoryItem("配管零件"))
            }

            onUI {
                categoryAdapter.submitList(categoryData)
            }
        }


        doAsync {
            titlePosition.clear()
            productData.clear()
            productData.apply {
                add(ProductItem(null, null, "直线运动零件", ItemCategory.TITLE))
                titlePosition.add(size - 1)
                add(ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "直线运动零件", ItemCategory.PRODUCT))
                add(ProductItem(null, null, "轴承/凸轮轴承随动器/旋转零件", ItemCategory.TITLE))
                titlePosition.add(size - 1)
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "轴承/凸轮轴承随动器/旋转零件",
                        ItemCategory.PRODUCT
                    )
                )
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "轴承/凸轮轴承随动器/旋转零件",
                        ItemCategory.PRODUCT
                    )
                )
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "轴承/凸轮轴承随动器/旋转零件",
                        ItemCategory.PRODUCT
                    )
                )
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "轴承/凸轮轴承随动器/旋转零件",
                        ItemCategory.PRODUCT
                    )
                )
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "轴承/凸轮轴承随动器/旋转零件",
                        ItemCategory.PRODUCT
                    )
                )
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "轴承/凸轮轴承随动器/旋转零件",
                        ItemCategory.PRODUCT
                    )
                )
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "轴承/凸轮轴承随动器/旋转零件",
                        ItemCategory.PRODUCT
                    )
                )
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "轴承/凸轮轴承随动器/旋转零件",
                        ItemCategory.PRODUCT
                    )
                )
                add(ProductItem(null, null, "连结连结机构部件", ItemCategory.TITLE))
                titlePosition.add(size - 1)
                add(ProductItem("产品名", R.drawable.ic_snapseed, "连结连结机构部件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "连结连结机构部件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "连结连结机构部件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "连结连结机构部件", ItemCategory.PRODUCT))
                add(ProductItem(null, null, "联轴器/带轮/传动", ItemCategory.TITLE))
                titlePosition.add(size - 1)
                add(ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "联轴器/带轮/传动", ItemCategory.PRODUCT))
                add(ProductItem(null, null, "马达/减速器/离合器制动机", ItemCategory.TITLE))
                titlePosition.add(size - 1)
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "马达/减速器/离合器制动机",
                        ItemCategory.PRODUCT
                    )
                )
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "马达/减速器/离合器制动机",
                        ItemCategory.PRODUCT
                    )
                )
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "马达/减速器/离合器制动机",
                        ItemCategory.PRODUCT
                    )
                )
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "马达/减速器/离合器制动机",
                        ItemCategory.PRODUCT
                    )
                )
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "马达/减速器/离合器制动机",
                        ItemCategory.PRODUCT
                    )
                )
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "马达/减速器/离合器制动机",
                        ItemCategory.PRODUCT
                    )
                )
                add(ProductItem(null, null, "传送机/滚轮/传送零件", ItemCategory.TITLE))
                titlePosition.add(size - 1)
                add(ProductItem("产品名", R.drawable.ic_snapseed, "传送机/滚轮/传送零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "传送机/滚轮/传送零件", ItemCategory.PRODUCT))
                add(ProductItem(null, null, "定位/固定零件", ItemCategory.TITLE))
                titlePosition.add(size - 1)
                add(ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "定位/固定零件", ItemCategory.PRODUCT))
                add(ProductItem(null, null, "滑台/光学部品/检查用部品", ItemCategory.TITLE))
                titlePosition.add(size - 1)
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "滑台/光学部品/检查用部品",
                        ItemCategory.PRODUCT
                    )
                )
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "滑台/光学部品/检查用部品",
                        ItemCategory.PRODUCT
                    )
                )
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "滑台/光学部品/检查用部品",
                        ItemCategory.PRODUCT
                    )
                )
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "滑台/光学部品/检查用部品",
                        ItemCategory.PRODUCT
                    )
                )
                add(
                    ProductItem(
                        "产品名",
                        R.drawable.ic_snapseed,
                        "滑台/光学部品/检查用部品",
                        ItemCategory.PRODUCT
                    )
                )
                add(ProductItem(null, null, "传感器/开关", ItemCategory.TITLE))
                titlePosition.add(size - 1)
                add(ProductItem("产品名", R.drawable.ic_snapseed, "传感器/开关", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "传感器/开关", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "传感器/开关", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "传感器/开关", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "传感器/开关", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "传感器/开关", ItemCategory.PRODUCT))
                add(ProductItem(null, null, "气动/液压设备", ItemCategory.TITLE))
                titlePosition.add(size - 1)
                add(ProductItem("产品名", R.drawable.ic_snapseed, "气动/液压设备", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "气动/液压设备", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "气动/液压设备", ItemCategory.PRODUCT))
                add(ProductItem(null, null, "真空零件", ItemCategory.TITLE))
                titlePosition.add(size - 1)
                add(ProductItem("产品名", R.drawable.ic_snapseed, "真空零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "真空零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "真空零件", ItemCategory.PRODUCT))
                add(ProductItem(null, null, "液压用装置", ItemCategory.TITLE))
                titlePosition.add(size - 1)
                add(ProductItem("产品名", R.drawable.ic_snapseed, "液压用装置", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "液压用装置", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "液压用装置", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "液压用装置", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "液压用装置", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "液压用装置", ItemCategory.PRODUCT))
                add(ProductItem(null, null, "涂装设备", ItemCategory.TITLE))
                titlePosition.add(size - 1)
                add(ProductItem("产品名", R.drawable.ic_snapseed, "涂装设备", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "涂装设备", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "涂装设备", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "涂装设备", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "涂装设备", ItemCategory.PRODUCT))
                add(ProductItem(null, null, "配管零件", ItemCategory.TITLE))
                titlePosition.add(size - 1)
                add(ProductItem("产品名", R.drawable.ic_snapseed, "配管零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "配管零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "配管零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "配管零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "配管零件", ItemCategory.PRODUCT))
                add(ProductItem("产品名", R.drawable.ic_snapseed, "配管零件", ItemCategory.PRODUCT))
            }

            onUI {
                productAdapter.submitList(productData)

                productLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return if (titlePosition.contains(position)) 3 else 1
                    }
                }

                var lastCategory = -1
                val smoothScrollerCenter = CenterSmoothScroller(context)

                binding.productList.addOnScrollListener(object : RecyclerView.OnScrollListener() {

                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)

                        if (currentCategory != categoryAdapter.currentItem) {
                            val last = productLayoutManager.findLastCompletelyVisibleItemPosition()
                            if (last > productData.size - 4) {
                                productData[last].categoryTitle?.let {
                                    if (it == categoryData[categoryData.size - 1].categoryTitle) {
                                        categoryAdapter.currentCategory(it)
                                        smoothScrollerCenter.targetPosition = categoryAdapter.currentItem
                                        categoryLayoutManager.startSmoothScroll(smoothScrollerCenter)
                                        return
                                    }
                                }
                            }


                            // 上方完全显示的item的类别
                            productData[productLayoutManager.findFirstCompletelyVisibleItemPosition()].categoryTitle?.let {
                                categoryAdapter.currentCategory(it)
                            }

                            if (lastCategory != categoryAdapter.currentItem) {
                                smoothScrollerCenter.targetPosition = categoryAdapter.currentItem
                                categoryLayoutManager.startSmoothScroll(smoothScrollerCenter)
                                lastCategory = categoryAdapter.currentItem
                            }
                        }

                    }

                    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                        super.onScrollStateChanged(recyclerView, newState)

                        if (newState == RecyclerView.SCROLL_STATE_DRAGGING || newState == RecyclerView.SCROLL_STATE_IDLE) {
                            currentCategory = -1
                        }
                    }
                })
            }
        }
    }
}