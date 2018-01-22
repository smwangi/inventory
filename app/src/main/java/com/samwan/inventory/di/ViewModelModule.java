package com.samwan.inventory.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.samwan.inventory.ui.main.MenuListViewModel;
import com.samwan.inventory.viewmodel.InventoryViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by smwangi on 1/17/18.
 */
@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MenuListViewModel.class)
    abstract ViewModel bindsMovieListViewModel(MenuListViewModel movieListViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(InventoryViewModelFactory movieViewModelFactory);
}
