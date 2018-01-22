package com.samwan.inventory.di;

import com.samwan.inventory.ui.main.MainActivity;
import com.samwan.inventory.ui.product.ProductActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by smwangi on 1/17/18.
 */
@Module
public abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract ProductActivity productActivity();
}
