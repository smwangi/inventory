package com.samwan.inventory.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samwan.inventory.R;
import com.samwan.inventory.data.local.entity.AppMenu;
import com.samwan.inventory.databinding.FragmentMenuListBinding;
import com.samwan.inventory.ui.BaseFragment;
import com.samwan.inventory.ui.product.ProductActivity;
import com.samwan.inventory.ui.product.ProductListFragment;

/**
 * Created by smwangi on 1/17/18.
 */

public class MenuListFragment extends BaseFragment<MenuListViewModel, FragmentMenuListBinding> implements MenuListCallback {
    private final String TAG = MenuListFragment.class.getName();
    public static MenuListFragment newInstance() {
        Bundle args = new Bundle();
        MenuListFragment fragment = new MenuListFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onMenuClicked(AppMenu appMenu, View sharedView) {
        ActivityOptionsCompat optionsCompat  = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),sharedView,"sharedimage");
        startActivity(ProductActivity.newIntent(getActivity(),appMenu.getPhoto()),optionsCompat.toBundle());
    }

    @Override
    public Class<MenuListViewModel> getViewModel() {
        return MenuListViewModel.class;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_menu_list;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        dataBinding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        dataBinding.recyclerView.setAdapter(new MenuListAdapter(this));
        return dataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(TAG,"OnActivityCreated Called");
        super.onActivityCreated(savedInstanceState);
        //viewModel.getMenus().all(l -> dataBinding.setResource(l));
        dataBinding.setMenuresource(viewModel.getMenus());
        Log.i(TAG,"OnActivityCreated Called getMenus"+viewModel.getMenus());
                //.observe(this, listResource -> dataBinding.setResource(listResource));
    }
}
