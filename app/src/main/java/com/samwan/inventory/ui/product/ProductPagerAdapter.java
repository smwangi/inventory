package com.samwan.inventory.ui.product;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by smwangi on 1/22/18.
 */

public class ProductPagerAdapter extends FragmentStatePagerAdapter {

    public ProductPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return ProductListFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 1;
    }
}
