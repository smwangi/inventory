package com.samwan.inventory.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.samwan.inventory.data.Test;
import com.samwan.inventory.ui.BaseAdapter;

/**
 * Created by smwangi on 1/17/18.
 */

public class MenuBindingAdapter {
    private static final String TAG = MenuBindingAdapter.class.getName();
    @BindingAdapter(value = "menuresource")
    public static void setMenuresource(RecyclerView recyclerView, Test menuresource){
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if(adapter == null)
            return;
        if(menuresource == null || menuresource.getAppMenus() ==null){
            Log.i(TAG,"Menu Resource App Menus is null  ");
            return;
        }

        if(adapter instanceof BaseAdapter){
            Log.i(TAG,"Menu Resource App Menus  "+menuresource.getAppMenus().size());
            ((BaseAdapter)adapter).setData(menuresource.getAppMenus());
        }
    }
}
