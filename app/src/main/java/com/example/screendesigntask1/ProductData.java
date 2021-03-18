package com.example.screendesigntask1;

import java.io.Serializable;

public class ProductData implements Serializable {
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImagesUrl() {
        return ImagesUrl;
    }

    public void setImagesUrl(int imagesUrl) {
        ImagesUrl = imagesUrl;
    }

    String productName = "";
    int price;
    int ImagesUrl;
}
