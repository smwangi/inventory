package com.samwan.inventory.ui.product;

import android.view.View;

import com.samwan.inventory.data.local.entity.ProductEntity;

/**
 * Created by smwangi on 1/22/18.
 */

public interface ProductCallback {
    void onProductClicked(ProductEntity productEntity, View sharedView);
}
