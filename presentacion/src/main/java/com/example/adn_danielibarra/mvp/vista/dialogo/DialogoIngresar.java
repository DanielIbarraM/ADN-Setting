package com.example.adn_danielibarra.mvp.vista.dialogo;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.adn_danielibarra.R;
import com.example.adn_danielibarra.mvp.vista.MainActivity;
import com.example.adn_danielibarra.mvp.vista.ObtenerVehiculoIngresado;
import com.example.adn_danielibarra.mvp.vista.VerificarVehiculo;
import com.example.dominio.modelo.Carro;
import com.example.dominio.modelo.Moto;
import com.example.dominio.modelo.Vehiculo;

import java.util.Calendar;

public class DialogoIngresar extends DialogFragment {

    RadioButton radioCarro;
    RadioButton radioMoto;
    EditText etPlaca;
    Button btnCancelar;
    Button btnRegistrar;
    EditText etCilindraje;
    LinearLayout contenedorCilindraje;
    MainActivity mainActivity;
    ObtenerVehiculoIngresado obtenerVehiculoIngresado;
    Vehiculo vehiculo;
    VerificarVehiculo verificarVehiculo;

    public DialogoIngresar(ObtenerVehiculoIngresado obtenerVehiculoIngresado, VerificarVehiculo verificarVehiculo) {
        this.obtenerVehiculoIngresado = obtenerVehiculoIngresado;
        this.verificarVehiculo =  verificarVehiculo;
    }

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        mainActivity = (MainActivity) getActivity();
        View view = mainActivity.getLayoutInflater().inflate(R.layout.dialogo_registrar_vehiculo, null);
        inicializar(view);
        builder.setView(view);
        setCancelable(false);
        return builder.create();
    }

    private void inicializar (View vista) {
        radioCarro = vista.findViewById(R.id.tipoCarro);
        radioMoto = vista.findViewById(R.id.tipoMoto);
        contenedorCilindraje = vista.findViewById(R.id.contenedorCilindraje);
        etPlaca = vista.findViewById(R.id.ed_placa);
        etPlaca.setAllCaps(true);
        etCilindraje = vista.findViewById(R.id.et_cilindraje);
        btnCancelar = vista.findViewById(R.id.btnCancelar);
        btnRegistrar = vista.findViewById(R.id.btnRegistrar);
        btnCancelar.setOnClickListener(v -> {
            dismiss();
        });
        btnRegistrar.setOnClickListener(v -> {
            if (!validarDatos()) {
                return;
            }
            crearVehiculo(etPlaca.getText().toString(), etCilindraje.getText().toString());
            obtenerVehiculoIngresado.obtenerVehiculo(vehiculo);
            dismiss();
        });

        radioCarro.setOnClickListener(v -> {
            contenedorCilindraje.setVisibility(View.GONE);
        });
        radioMoto.setOnClickListener(v -> {
            contenedorCilindraje.setVisibility(View.VISIBLE);
        });
    }

    private boolean validarDatos () {
        if (etPlaca.getText().toString().isEmpty()){
            mainActivity.mostrarDialogoAlerta(R.string.informacion, "Ingrese placa del vehiculo");
            return false;
        }

        if (!(etPlaca.getText().toString().length() >= 6 && etPlaca.getText().toString().length() <=10)){
            mainActivity.mostrarDialogoAlerta(R.string.informacion, "La placa debe contener de 6  a 10 caracteres");
            return false;
        }

        if (verificarVehiculo.verificarExistenciaVehiculo(etPlaca.getText().toString())){
            mainActivity.mostrarDialogoAlerta(R.string.informacion, "Este vehiculo ya está registrado");
            return false;
        }

        if (radioMoto.isChecked() && etCilindraje.getText().toString().isEmpty()){
            mainActivity.mostrarDialogoAlerta(R.string.informacion, "Ingrese cilindraje de la moto");
            return false;
        }
        return true;
    }

    private void crearVehiculo(String placa, String cilindraje) {
        if (radioCarro.isChecked()) {
            vehiculo = new Carro(placa);
        } else {
            vehiculo = new Moto(placa, Integer.parseInt(cilindraje));
        }
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
    }
}
