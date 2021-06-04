package com.dim.retrofitgetrvexample.ui;

import retrofit.RestAdapter;

public class API {
    private static final String url = "http://mobileappdatabase.in/";

    public static ApiInterface getCliente(){
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(url)
                .build();

        ApiInterface apiInterface = adapter.create(ApiInterface.class);
        return apiInterface;
    }
}
