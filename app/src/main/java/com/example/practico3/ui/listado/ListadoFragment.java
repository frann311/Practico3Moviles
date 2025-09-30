package com.example.practico3.ui.listado;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.practico3.Modelo.Producto;
import com.example.practico3.databinding.FragmentListadoBinding;

import java.util.ArrayList;

public class ListadoFragment extends Fragment {

    private FragmentListadoBinding binding;
    private ListadoViewModel vm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentListadoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        vm= new ViewModelProvider(this).get(ListadoViewModel.class);

        vm.getListaProductos().observe(getViewLifecycleOwner(), new Observer<ArrayList<Producto>>() {
            @Override
            public void onChanged(ArrayList<Producto> productos) {
            ProductoAdapter pa= new ProductoAdapter(productos, getContext(), getLayoutInflater());
                GridLayoutManager glm= new GridLayoutManager(getContext(),1, GridLayoutManager.VERTICAL,false) ;
            binding.lista.setLayoutManager(glm);
                binding.lista.setAdapter(pa);
            }
        });
        vm.ordenarLista();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}