package com.samwan.inventory.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samwan.inventory.R;
import com.samwan.inventory.data.local.entity.ProductEntity;
import com.samwan.inventory.databinding.FragmentProductListBinding;
import com.samwan.inventory.ui.BaseFragment;

/**
 * Created by smwangi on 1/22/18.
 */

public class ProductListFragment extends BaseFragment<ProductViewModel,FragmentProductListBinding> implements ProductCallback {

    public static ProductListFragment newInstance() {
        Bundle bundle = new Bundle();
        ProductListFragment fragment = new ProductListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle savedInstanceState){
        super.onCreateView(layoutInflater,viewGroup,savedInstanceState);
        dataBinding.productRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        dataBinding.productRecyclerView.setAdapter(new ProductAdapter(this));
        return dataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        viewModel.getProducts()
                .observe(this, p -> dataBinding.setResource(p));
    }
    @Override
    public void onProductClicked(ProductEntity productEntity, View sharedView) {
        ActivityOptionsCompat optionsCompat  = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),sharedView,"productId");
       // startActivity();
    }

    @Override
    public Class<ProductViewModel> getViewModel() {
        return ProductViewModel.class;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_menu_list;
    }
}
