package com.samwan.inventory.ui.main;

import android.view.View;

import com.samwan.inventory.data.local.entity.AppMenu;

/**
 * Created by smwangi on 1/17/18.
 */

public interface MenuListCallback {
    void onMenuClicked(AppMenu appMenu, View sharedView);
}
