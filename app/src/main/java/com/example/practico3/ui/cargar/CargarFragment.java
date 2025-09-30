package com.example.practico3.ui.cargar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.practico3.databinding.FragmentCargarBinding;

public class CargarFragment extends Fragment {

    private FragmentCargarBinding binding;
    private CargarViewModel mv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mv= new ViewModelProvider(this).get(CargarViewModel.class);
        binding.btAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigoProdStr = binding.etCodigoProd.getText().toString();
                String descripcionProd = binding.etDescripcionProd.getText().toString();
                String precioProdStr = binding.etPrecioProd.getText().toString();
                mv.agregarProducto(codigoProdStr, descripcionProd, precioProdStr);
            }

        });
        mv.getMensajeErr().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvInfo.setText(s);
            }
        });
        mv.getMensajeOk().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.etCodigoProd.setText("");
                binding.etDescripcionProd.setText("");
                binding.etPrecioProd.setText("");

                binding.tvInfo.setText(s);
            }
        });



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}