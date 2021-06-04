package com.dim.retrofitgetrvexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dim.retrofitgetrvexample.R;
import com.dim.retrofitgetrvexample.model.UsuarioResponse;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuariosViewHolder> {
    Context context;
    List<UsuarioResponse> listadoUsuarios;

    public UsuarioAdapter(Context context, List<UsuarioResponse> listadoUsuarios) {
        this.context = context;
        this.listadoUsuarios = listadoUsuarios;
    }

    @Override
    public UsuariosViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(context).inflate(R.layout.user_list_items, null);
        UsuariosViewHolder uVH = new UsuariosViewHolder(v);
        return uVH;
    }

    @Override
    public void onBindViewHolder(UsuariosViewHolder holder, final int position){
        holder.tvNombre.setText("Nombre: " + listadoUsuarios.get(position).getNombre());
        holder.tvEmail.setText("Email: " + listadoUsuarios.get(position).getEmail());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(context, listadoUsuarios.get(position).getNombre(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount(){
        if (listadoUsuarios != null){
            return listadoUsuarios.size();
        }else{
            return 0;
        }
    }

    public class UsuariosViewHolder extends RecyclerView.ViewHolder{
        TextView tvNombre, tvEmail;

        public UsuariosViewHolder(View itemView){
            super(itemView);
            tvNombre = (TextView)itemView.findViewById(R.id.tvNombre);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
        }

    }
}
