package com.example.adn_danielibarra.mvp.presentador;

import android.content.Context;

import com.example.adn_danielibarra.R;
import com.example.adn_danielibarra.mvp.modelo.RepositorioParqueaderoImpl;
import com.example.adn_danielibarra.mvp.modelo.contrato.RepositorioParqueadero;
import com.example.adn_danielibarra.mvp.presentador.contratos.PresentadorParqueadero;
import com.example.adn_danielibarra.mvp.vista.contratos.VistaParqueadero;
import com.example.dominio.excepcionnegocio.PlacaNoPermitidaExcepcion;
import com.example.dominio.excepcionnegocio.PlacaNoValidaExcepcion;
import com.example.dominio.excepcionnegocio.SinCupoExcepcion;
import com.example.dominio.modelo.Vehiculo;

import java.util.List;

public class PresentadorParqueaderoImpl implements PresentadorParqueadero {

    VistaParqueadero vista;
    RepositorioParqueadero repositorio;

    public PresentadorParqueaderoImpl(VistaParqueadero vistaParqueadero, Context context) {
        this.vista = vistaParqueadero;
        this.repositorio = new RepositorioParqueaderoImpl(this, context);
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
        } catch (PlacaNoPermitidaExcepcion | PlacaNoValidaExcepcion | SinCupoExcepcion excepcion) {
            vista.mostrarDialogoAlerta(R.string.informacion, excepcion.getMessage());
        }
    }

    @Override
    public int calcularTotal(Vehiculo vehiculo) {
        return repositorio.calcularTotalVehiculo(vehiculo);
    }
}
