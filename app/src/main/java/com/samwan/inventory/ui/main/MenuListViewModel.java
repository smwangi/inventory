package com.samwan.inventory.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.samwan.inventory.R;
import com.samwan.inventory.data.Resource;
import com.samwan.inventory.data.Test;
import com.samwan.inventory.data.local.entity.AppMenu;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by smwangi on 1/17/18.
 */

public class MenuListViewModel extends ViewModel {
    private Test menus;
    private final String TAG = MenuListViewModel.class.getName();

    @Inject
    public MenuListViewModel(){
        menus = getMenus();
    }

    public Test getMenus(){
        List<AppMenu> appMenus = new ArrayList<>();
        appMenus.add(new AppMenu("Products", R.drawable.product));
        appMenus.add(new AppMenu("Sales", R.drawable.sales));
        Log.i(TAG,"Menu List view model get menus >> "+appMenus.size());
        Test test = new Test(appMenus);
        test.setAppMenus(appMenus);

        return test;
    }

}
