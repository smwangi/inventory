package com.samwan.inventory.data;

import android.support.annotation.Nullable;

import com.samwan.inventory.data.local.entity.AppMenu;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by smwangi on 1/17/18.
 */

public class Test {

    private  List<AppMenu> appMenus;

    public Test(List<AppMenu> appMenus){
        this.appMenus = appMenus;
    }

    public List<AppMenu> getAppMenus(){
        return this.appMenus;
    }

    public void setAppMenus(List<AppMenu> appMenus){
        this.appMenus = appMenus;
    }

}
