package com.samwan.inventory.data.remote.repository;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.samwan.inventory.data.NetworkBoundResource;
import com.samwan.inventory.data.Resource;
import com.samwan.inventory.data.local.dao.ProductDao;
import com.samwan.inventory.data.local.entity.ProductEntity;
import com.samwan.inventory.data.remote.APIResponse;
import com.samwan.inventory.data.remote.APIService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by smwangi on 1/22/18.
 */

public class ProductRepository {

    private final ProductDao productDao;
    private final APIService apiService;

    @Inject
    public ProductRepository(ProductDao productDao, APIService apiService){
        this.productDao = productDao;
        this.apiService = apiService;
    }

    public LiveData<Resource<List<ProductEntity>>> loadProducts() {
        return new NetworkBoundResource<List<ProductEntity>,APIResponse<ProductEntity>>(){

            @Override
            protected void saveCallResult(@NonNull APIResponse<ProductEntity> item) {
                if(item !=null){
                    productDao.save(item.getResults());
                }
            }

            @NonNull
            @Override
            protected LiveData<List<ProductEntity>> loadFromDb() {
                return productDao.fecthAll();
            }

            @NonNull
            @Override
            protected Call<APIResponse<ProductEntity>> createCall() {
                return apiService.loadProducts();
            }
        }.getAsLiveData();
    }
}
