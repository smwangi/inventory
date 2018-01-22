package com.samwan.inventory.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.samwan.inventory.data.local.AppDatabase;
import com.samwan.inventory.data.local.dao.ProductDao;
import com.samwan.inventory.data.remote.APIService;
import com.samwan.inventory.data.remote.ApiConstants;
import com.samwan.inventory.data.remote.RequestInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by smwangi on 1/17/18.
 */
@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    OkHttpClient providerOkHttpClient(){
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(ApiConstants.TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(ApiConstants.TIMEOUT_IN_SEC,TimeUnit.SECONDS);
        okHttpClientBuilder.addInterceptor(new RequestInterceptor());
        return okHttpClientBuilder.build();
    }

    @Provides
    @Singleton
    APIService providerRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(APIService.class);
    }

    @Provides
    @Singleton
    AppDatabase providerAppDatabase(Application application) {
        return Room.databaseBuilder(application,AppDatabase.class,"inventory.db").build();
    }

    @Provides
    @Singleton
    ProductDao providerProductDao(AppDatabase appDatabase){
        return appDatabase.productDao();
    }

}
