package com.samwan.inventory.ui.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.samwan.inventory.R;
import com.samwan.inventory.databinding.ActivityMainBinding;
import com.samwan.inventory.ui.BaseActivity;

import dagger.android.AndroidInjector;

/**
 * Created by smwangi on 1/17/18.
 */

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding.viewPager.setAdapter(new MenusPagerAdapter(getSupportFragmentManager()));
        dataBinding.viewPager.setOffscreenPageLimit(1);
    }

}
