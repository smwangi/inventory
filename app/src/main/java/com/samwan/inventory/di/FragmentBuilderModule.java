package com.samwan.inventory.di;

import com.samwan.inventory.ui.main.MenuListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by smwangi on 1/17/18.
 */
@Module
public abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract MenuListFragment contributeMenuListFragment();
}
