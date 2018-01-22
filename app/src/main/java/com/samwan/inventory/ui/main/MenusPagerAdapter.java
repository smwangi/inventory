package com.samwan.inventory.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by smwangi on 1/17/18.
 */

public class MenusPagerAdapter extends FragmentStatePagerAdapter {
    private static final String[] titles = new String[]{"Popular"};

    public MenusPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        return MenuListFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
