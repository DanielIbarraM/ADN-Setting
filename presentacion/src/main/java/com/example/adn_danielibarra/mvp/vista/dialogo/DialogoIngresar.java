package com.example.adn_danielibarra.mvp.vista.dialogo;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.adn_danielibarra.R;
import com.example.adn_danielibarra.databinding.DialogoRegistrarVehiculoBinding;
import com.example.adn_danielibarra.mvp.vista.MainActivity;
import com.example.adn_danielibarra.mvp.vista.ObtenerVehiculoIngresado;
import com.example.adn_danielibarra.mvp.vista.VerificarVehiculo;
import com.example.dominio.modelo.Carro;
import com.example.dominio.modelo.Moto;
import com.example.dominio.modelo.Vehiculo;

import java.util.Calendar;

public class DialogoIngresar extends DialogFragment {

    ObtenerVehiculoIngresado obtenerVehiculoIngresado;
    Vehiculo vehiculo;
    VerificarVehiculo verificarVehiculo;
    MainActivity mainActivity;
    DialogoRegistrarVehiculoBinding binding;

    public DialogoIngresar(ObtenerVehiculoIngresado obtenerVehiculoIngresado, VerificarVehiculo verificarVehiculo) {
        this.obtenerVehiculoIngresado = obtenerVehiculoIngresado;
        this.verificarVehiculo =  verificarVehiculo;
    }

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = DialogoRegistrarVehiculoBinding.inflate(getLayoutInflater());
        mainActivity = (MainActivity) getActivity();
        View view = binding.getRoot();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        inicializar();
        builder.setView(view);
        setCancelable(false);
        return builder.create();
    }

    private void inicializar () {
        binding.edPlaca.setAllCaps(true);
        binding.btnCancelar.setOnClickListener(v -> {
            dismiss();
        });
        binding.btnRegistrar.setOnClickListener(v -> {
            if (!validarDatos()) {
                return;
            }
            crearVehiculo(binding.edPlaca.getText().toString(), binding.etCilindraje.getText().toString());
            obtenerVehiculoIngresado.obtenerVehiculo(vehiculo);
            dismiss();
        });

        binding.tipoCarro.setOnClickListener(v -> {
            binding.contenedorCilindraje.setVisibility(View.GONE);
        });
        binding.tipoMoto.setOnClickListener(v -> {
            binding.contenedorCilindraje.setVisibility(View.VISIBLE);
        });
    }

    private boolean validarDatos () {
        if (binding.edPlaca.getText().toString().isEmpty()){
            mainActivity.mostrarDialogoAlerta(R.string.informacion, "Ingrese placa del vehiculo");
            return false;
        }

        if (!(binding.edPlaca.getText().toString().length() >= 6 && binding.edPlaca.getText().toString().length() <=10)){
            mainActivity.mostrarDialogoAlerta(R.string.informacion, "La placa debe contener de 6  a 10 caracteres");
            return false;
        }

        if (verificarVehiculo.verificarExistenciaVehiculo(binding.edPlaca.getText().toString())){
            mainActivity.mostrarDialogoAlerta(R.string.informacion, "Este vehiculo ya está registrado");
            return false;
        }

        if (binding.tipoMoto.isChecked() && binding.etCilindraje.getText().toString().isEmpty()){
            mainActivity.mostrarDialogoAlerta(R.string.informacion, "Ingrese cilindraje de la moto");
            return false;
        }
        return true;
    }

    private void crearVehiculo(String placa, String cilindraje) {
        if (binding.tipoCarro.isChecked()) {
            vehiculo = new Carro(placa);
        } else {
            vehiculo = new Moto(placa, Integer.parseInt(cilindraje));
        }
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
    }
}
