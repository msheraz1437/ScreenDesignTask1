package com.example.screendesigntask1.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.screendesigntask1.ProductData;
import com.example.screendesigntask1.R;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<List<ProductData>> productDataMutableLiveData;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        productDataMutableLiveData = new MutableLiveData<>();
        mText.setValue("This is home fragment");
        List<ProductData> productDataList = new ArrayList<>();
        ProductData productData = new ProductData();
        productData.setImagesUrl(R.drawable.image_1);
        productData.setPrice(849);
        productData.setProductName("Sofa Baleria");
        productDataList.add(productData);

        ProductData productData1 = new ProductData();
        productData1.setImagesUrl(R.drawable.image_2);
        productData1.setPrice(949);
        productData1.setProductName("Dining Table");
        productDataList.add(productData1);

        ProductData productData2 = new ProductData();
        productData2.setImagesUrl(R.drawable.image_3);
        productData2.setPrice(999);
        productData2.setProductName("Fabric Sofa");
        productDataList.add(productData2);
        productDataMutableLiveData.setValue(productDataList);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<ProductData>> getProductDataList() {
        return productDataMutableLiveData;
    }
}