package com.samwan.inventory.data;

/**
 * Created by smwangi on 1/17/18.
 * Status of the resource that is provided to the UI
 * They are usually created by the Repository classes where they return latest data to the UI with its fetch status
 */

public enum Status {
    SUCCESS,
    ERROR,
    LOADING
}
