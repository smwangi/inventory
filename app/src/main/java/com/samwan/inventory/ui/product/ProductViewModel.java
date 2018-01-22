package com.samwan.inventory.ui.product;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.persistence.room.Insert;

import com.samwan.inventory.data.Resource;
import com.samwan.inventory.data.local.entity.ProductEntity;
import com.samwan.inventory.data.remote.repository.ProductRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by smwangi on 1/22/18.
 */

public class ProductViewModel extends ViewModel {

    private final LiveData<Resource<List<ProductEntity>>> products;

    @Inject
    public ProductViewModel(ProductRepository productRepository){
        this.products = productRepository.loadProducts();
    }

    LiveData<Resource<List<ProductEntity>>> getProducts(){
        return products;
    }
}
