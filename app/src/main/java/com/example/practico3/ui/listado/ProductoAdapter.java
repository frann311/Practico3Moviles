package com.example.practico3.ui.listado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practico3.Modelo.Producto;
import com.example.practico3.R;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolderProducto> {


    private List<Producto> listaProductos;
    private Context context;
    private LayoutInflater inflater;

    public ProductoAdapter(List<Producto> listaProductos, Context context, LayoutInflater inflater) {
        this.listaProductos = listaProductos;
        this.context = context;
        this.inflater = inflater;
    }
    @NonNull
    @Override
    public ViewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=inflater.inflate(R.layout.item,parent,false);
        return new ViewHolderProducto(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProducto holder, int position) {
        Producto prodActual = listaProductos.get(position);
        holder.descripcion.setText("Descripcion: "+prodActual.getDescripcion());
        holder.codigo.setText("Codigo: "+String.valueOf(prodActual.getCodigo()));
        holder.precio.setText("Precio: "+ "$"+String.valueOf(prodActual.getPrecio()));
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public  class ViewHolderProducto extends RecyclerView.ViewHolder{

        TextView descripcion,codigo,precio;

        public ViewHolderProducto(@NonNull View itemView) {
            super(itemView);
            descripcion=itemView.findViewById(R.id.tvDescripcion);
            codigo=itemView.findViewById(R.id.tvCodigo);
            precio=itemView.findViewById(R.id.tvPrecio);
        }
    }
}
