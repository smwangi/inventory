package com.samwan.inventory.data.local.entity;

import java.util.List;

/**
 * Created by smwangi on 1/17/18.
 */

public class AppMenu {

    private String name;

    private int photo;

    public AppMenu(String name, int photo) {
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return this.photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

}
