package com.samwan.inventory.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.samwan.inventory.data.local.dao.ProductDao;
import com.samwan.inventory.data.local.entity.ProductEntity;

/**
 * Created by smwangi on 1/22/18.
 */
@Database(entities = {ProductEntity.class},version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProductDao productDao();
}
