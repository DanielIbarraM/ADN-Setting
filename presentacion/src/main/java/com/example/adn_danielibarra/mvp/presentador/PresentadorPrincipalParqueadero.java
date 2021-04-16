package com.example.adn_danielibarra.mvp.presentador;

import android.content.Context;

import com.example.adn_danielibarra.R;
import com.example.adn_danielibarra.mvp.modelo.RepositorioPrincipalParqueadero;
import com.example.adn_danielibarra.mvp.modelo.contrato.RepositorioPrincipal;
import com.example.adn_danielibarra.mvp.presentador.contratos.PresentadorPrincipal;
import com.example.adn_danielibarra.mvp.vista.contratos.VistaPrincipal;
import com.example.dominio.excepcionnegocio.SinCupoExcepcion;
import com.example.dominio.modelo.entidad.Vehiculo;

import java.util.List;

public class PresentadorPrincipalParqueadero implements PresentadorPrincipal {

    VistaPrincipal vista;
    RepositorioPrincipal repositorio;

    public PresentadorPrincipalParqueadero(VistaPrincipal vistaPrincipal, Context context) {
        this.vista = vistaPrincipal;
        this.repositorio = new RepositorioPrincipalParqueadero(this, context);
    }

    @Override
    public void obtenerVehiculos() {
        repositorio.obtenerVehiculos();
    }

    @Override
    public void mostrarVehiculos(List<Vehiculo> vehiculoLista) {
        if (vehiculoLista == null || vehiculoLista.size() == 0) {
            vista.mostrarDialogoAlerta(R.string.informacion, R.string.no_hay_vehiculos);
            vista.mostrarSinVehiculos();
        } else {
            vista.mostrarVehiculos(vehiculoLista);
        }

    }

    @Override
    public void eliminarVehiculo(Vehiculo vehiculo) {
        repositorio.eliminarVehiculo(vehiculo);
    }

    @Override
    public int obtenerCantidadCarros() {
        return repositorio.obtenerCantidadCarros();
    }

    @Override
    public int obtenerCantidadMotos() {
        return repositorio.obtenerCantidadMotos();
    }

    @Override
    public void ingresarVehiculo(Vehiculo vehiculo) {
        try {
            repositorio.ingresarVehiculo(vehiculo);
        }catch (SinCupoExcepcion excepcion){
            vista.mostrarDialogoAlerta(R.string.informacion, excepcion.getMessage());
        }
    }
}
