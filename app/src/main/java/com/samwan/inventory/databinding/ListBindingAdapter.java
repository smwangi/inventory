package com.samwan.inventory.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.samwan.inventory.data.Resource;
import com.samwan.inventory.ui.BaseAdapter;

import java.util.List;

/**
 * Created by smwangi on 1/17/18.
 */

public class ListBindingAdapter {
    @BindingAdapter(value = "resource")
    public static void setResource(RecyclerView recyclerView, Resource resource){
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if(adapter == null)
            return;

        if(resource == null || resource.data == null)
            return;

        if(adapter instanceof BaseAdapter){
            ((BaseAdapter)adapter).setData((List) resource.data);
        }
    }
}
