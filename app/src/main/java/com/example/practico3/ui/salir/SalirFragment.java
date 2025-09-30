package com.example.practico3.ui.salir;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.practico3.databinding.FragmentSalirBinding;


public class SalirFragment extends Fragment {


    private FragmentSalirBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentSalirBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        new AlertDialog.Builder(getActivity())
                .setTitle("Salir")
                .setMessage("¿Desea salir de la aplicación?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}