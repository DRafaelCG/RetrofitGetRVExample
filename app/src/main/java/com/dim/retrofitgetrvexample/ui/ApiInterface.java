package com.dim.retrofitgetrvexample.ui;

import com.dim.retrofitgetrvexample.model.UsuarioResponse;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface ApiInterface {
    @GET("/retrofit/getUser.php")
    public void getListadoUsuarios(Callback<List<UsuarioResponse>> callback);
}
