package com.samwan.inventory.data.remote;

import java.util.List;

/**
 * Created by smwangi on 1/22/18.
 */

public class APIResponse<T> {

    private List<T> results;

    public List<T> getResults(){
        return results;
    }

    public void setResults(List<T> results){
        this.results = results;
    }
}
