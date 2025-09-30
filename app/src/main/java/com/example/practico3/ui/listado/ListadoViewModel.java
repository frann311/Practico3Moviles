package com.example.practico3.ui.listado;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import static com.example.practico3.MainActivity.*;

import com.example.practico3.Modelo.Producto;

import java.util.ArrayList;
import java.util.Comparator;

public class ListadoViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Producto>> listaProductos;
    public ListadoViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<ArrayList<Producto>> getListaProductos(){
        if (listaProductos==null){
            listaProductos=new MutableLiveData<>();
        }
        return listaProductos;
    }

    public void ordenarLista() {
        productos.sort(new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return o1.getDescripcion().compareTo(o2.getDescripcion());
            }
        });
        listaProductos.setValue(productos);

    }

}