package com.samwan.inventory.ui;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by smwangi on 1/17/18.
 */

public abstract class BaseAdapter<Type extends RecyclerView.ViewHolder, Data> extends RecyclerView.Adapter<Type> {
    public abstract void setData(List<Data> data);
}
