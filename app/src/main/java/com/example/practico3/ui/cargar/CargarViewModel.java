package com.example.practico3.ui.cargar;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.practico3.MainActivity;
import com.example.practico3.Modelo.Producto;
import static  com.example.practico3.MainActivity.*;

import java.util.ArrayList;

public class CargarViewModel extends AndroidViewModel {


    private MutableLiveData<String> mensajeErr;
    private MutableLiveData<String> mensajeOk;

    public CargarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMensajeErr(){
        if (mensajeErr==null){
            mensajeErr=new MutableLiveData<>();
        }
        return mensajeErr;
    }
    public LiveData<String> getMensajeOk(){
        if (mensajeOk==null){
            mensajeOk=new MutableLiveData<>();
        }
        return mensajeOk;
    }


    public void agregarProducto(String codigoStr, String descripcion, String precioStr) {
        if (codigoStr.isEmpty() || descripcion.isEmpty() || precioStr.isEmpty()) {
            mensajeErr.setValue("No puede haber campos vacíos");
            return;
        }

        double precio;
        try {
            precio = Double.parseDouble(precioStr);
        } catch (NumberFormatException e) {
            mensajeErr.setValue("El precio debe ser un número válido");
            return;
        }

        int codigo;
        try {
            codigo = Integer.parseInt(codigoStr);

        } catch (NumberFormatException e) {
            mensajeErr.setValue("El código debe ser un número válido");
            return;
        }

        Producto p = new Producto(codigo, descripcion, precio);
        if (productos.contains(p)) {
            mensajeErr.setValue("El producto ya existe");
            return;
        }
        productos.add(p);
        mensajeOk.setValue("Producto agregado Correctamente");



    }

}