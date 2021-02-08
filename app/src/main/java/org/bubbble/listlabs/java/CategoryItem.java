package org.bubbble.listlabs.java;

/**
 * @author Andrew
 * @date 2021/02/08 12:14
 */
public class CategoryItem {

    public CategoryItem(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    private String categoryTitle;

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}
