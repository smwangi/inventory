package com.samwan.inventory.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.samwan.inventory.data.local.entity.AppMenu;
import com.samwan.inventory.databinding.ItemMenuListBinding;
import com.samwan.inventory.ui.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smwangi on 1/17/18.
 */

public class MenuListAdapter extends BaseAdapter<MenuListAdapter.MenuViewHolder, AppMenu> {
    private final String TAG = MenuListAdapter.class.getName();

    private List<AppMenu> appMenuList;

    private final MenuListCallback menuListCallback;

    public MenuListAdapter(MenuListCallback menuListCallback){
        Log.i(TAG,"Menu List Adapter");
        this.menuListCallback = menuListCallback;
        this.appMenuList = new ArrayList<>();
    }

    @Override
    public void setData(List<AppMenu> appMenuList) {
        this.appMenuList = appMenuList;
        notifyDataSetChanged();
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Log.i(TAG,"Menu On Create View Holder");
        return MenuViewHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup, menuListCallback   );
    }

    @Override
    public void onBindViewHolder(MenuViewHolder viewHolder, int i) {
        Log.i(TAG,"Menu List Adapter On Bind View Holder "+i);
        Log.i(TAG,"Menu List Adapter On Bind View Holder menu photo "+appMenuList.get(i).getPhoto());
        viewHolder.onBind(appMenuList.get(i));
    }

    @Override
    public int getItemCount() {
        Log.i(TAG,"Menu List Adapter Menu Size Count "+ appMenuList.size());
        return appMenuList.size();
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {
        private final String TAG = MenuViewHolder.class.getName();
        public static MenuViewHolder create(LayoutInflater inflater, ViewGroup parent, MenuListCallback callback) {
            ItemMenuListBinding itemMovieListBinding = ItemMenuListBinding.inflate(inflater, parent, false);
            return new MenuViewHolder(itemMovieListBinding, callback);
        }

        ItemMenuListBinding binding;

        public MenuViewHolder(ItemMenuListBinding binding, MenuListCallback callback) {
            super(binding.getRoot());
            this.binding = binding;
            Log.i(TAG,"Menu View Holder Binding Image  "+ binding.imageViewCover.getDrawable());
            binding.getRoot().setOnClickListener(v ->
                    callback.onMenuClicked(binding.getName(), binding.imageViewCover));
        }

        public void onBind(AppMenu appMenu) {
            Log.i(TAG,"Menu View Holder on Bind  "+ appMenu.getName());
            binding.setName(appMenu);
            binding.executePendingBindings();
        }
    }
}
