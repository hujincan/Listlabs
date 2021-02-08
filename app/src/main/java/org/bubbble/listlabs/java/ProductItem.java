package org.bubbble.listlabs.java;

/**
 * @author Andrew
 * @date 2021/02/08 12:14
 */
public class ProductItem {

    public ProductItem(String productName, Integer productImage, String categoryTitle, ItemCategory type) {
        this.productName = productName;
        this.productImage = productImage;
        this.categoryTitle = categoryTitle;
        this.type = type;
    }

    private String productName;
    private Integer productImage;
    private String categoryTitle;
    private ItemCategory type;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductImage() {
        return productImage;
    }

    public void setProductImage(Integer productImage) {
        this.productImage = productImage;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public ItemCategory getType() {
        return type;
    }

    public void setType(ItemCategory type) {
        this.type = type;
    }
}

enum ItemCategory {
    TITLE,
    PRODUCT
}
