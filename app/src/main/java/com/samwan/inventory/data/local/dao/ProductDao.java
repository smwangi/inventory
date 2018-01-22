package com.samwan.inventory.data.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.samwan.inventory.data.local.entity.ProductEntity;

import java.util.List;

/**
 * Created by smwangi on 1/22/18.
 */

@Dao
public interface ProductDao {
    @Query("select * from products")
    LiveData<List<ProductEntity>>fecthAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(List<ProductEntity> productEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSingle(ProductEntity productEntity);

    @Query("SELECT * FROM products WHERE name LIKE :name LIMIT 1")
    ProductEntity findByName(String name);

    @Update
    void update(ProductEntity entity);

    @Delete
    void delete(ProductEntity entity);
}
