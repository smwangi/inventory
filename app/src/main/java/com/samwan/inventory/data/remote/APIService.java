package com.samwan.inventory.data.remote;

import com.samwan.inventory.data.local.entity.ProductEntity;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by smwangi on 1/22/18.
 */

public interface APIService {

    @GET("product/list")
    Call<APIResponse<ProductEntity>> loadProducts();

}
