package com.samwan.inventory.ui.product;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.samwan.inventory.data.local.entity.ProductEntity;
import com.samwan.inventory.databinding.ProductListBinding;
import com.samwan.inventory.ui.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smwangi on 1/22/18.
 */

public class ProductAdapter extends BaseAdapter<ProductAdapter.ProductViewHolder,ProductEntity> {
    private List<ProductEntity> productEntityList;
    private final ProductCallback productCallback;

    public ProductAdapter(ProductCallback productCallback){
        this.productEntityList = new ArrayList<>();
        this.productCallback = productCallback;
    }

    @Override
    public void setData(List<ProductEntity> productEntities) {
        this.productEntityList = productEntities;
        notifyDataSetChanged();
    }

    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ProductViewHolder.create(LayoutInflater.from(parent.getContext()),parent,productCallback);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ProductViewHolder holder, int position) {
        holder.onBind(productEntityList.get(position));
    }

    @Override
    public int getItemCount() {
        return productEntityList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {

        public static ProductViewHolder create(LayoutInflater inflater,ViewGroup viewGroup, ProductCallback productCallback) {
            ProductListBinding productListBinding  = ProductListBinding.inflate(inflater,viewGroup,false);
            return new ProductViewHolder(productListBinding,productCallback);
        }

        ProductListBinding binding;
        public ProductViewHolder(ProductListBinding binding, ProductCallback callback) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(p -> callback.onProductClicked(binding.getProduct(),binding.productId));
        }

        public void onBind(ProductEntity productEntity){
            binding.setProduct(productEntity);
            binding.executePendingBindings();
        }
    }
}
