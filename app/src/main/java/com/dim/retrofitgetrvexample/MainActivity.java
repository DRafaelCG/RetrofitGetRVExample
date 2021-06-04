package com.dim.retrofitgetrvexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.dim.retrofitgetrvexample.adapter.UsuarioAdapter;
import com.dim.retrofitgetrvexample.model.UsuarioResponse;
import com.dim.retrofitgetrvexample.ui.API;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvDatos;
    List<UsuarioResponse> listadoUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvDatos = (RecyclerView)findViewById(R.id.rvDatos);
        getListadoUsuarios();
    }

    private void getListadoUsuarios(){
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Espere por favot...");
        pDialog.show();

        API.getCliente().getListadoUsuarios(new Callback<List<UsuarioResponse>>() {
            @Override
            public void success(List<UsuarioResponse> usuarioResponses, Response response) {
                pDialog.dismiss();
                listadoUsuarios = usuarioResponses;
                setDatosRecyclerView();
            }

            @Override
            public void failure(RetrofitError error) {
                pDialog.dismiss();
                muestraToast(error.toString());
            }
        });
    }

    private void muestraToast(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    private void setDatosRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rvDatos.setLayoutManager(linearLayoutManager);

        UsuarioAdapter uAdapter = new UsuarioAdapter(MainActivity.this, listadoUsuarios);
        rvDatos.setAdapter(uAdapter);
    }
}