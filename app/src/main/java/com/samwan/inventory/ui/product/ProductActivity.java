package com.samwan.inventory.ui.product;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.samwan.inventory.R;
import com.samwan.inventory.databinding.ProductBinding;
import com.samwan.inventory.ui.BaseActivity;

/**
 * Created by smwangi on 1/22/18.
 */

public class ProductActivity extends BaseActivity<ProductBinding> implements LifecycleOwner {

    private static final String KEY_MENU_ID = "key_menu_id";
    //LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);


    @Override
    public int getLayoutRes() {
        return R.layout.product;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        dataBinding.productViewPager.setAdapter(new ProductPagerAdapter(getSupportFragmentManager()));
        dataBinding.productViewPager.setOffscreenPageLimit(1);
    }

    public static Intent newIntent(Context context,int menuId){
        Intent intent = new Intent(context,ProductActivity.class);
        intent.putExtra(KEY_MENU_ID,menuId);
        return intent;
    }

}
