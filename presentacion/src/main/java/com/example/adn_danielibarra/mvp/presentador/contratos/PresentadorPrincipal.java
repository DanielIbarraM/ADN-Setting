package com.example.adn_danielibarra.mvp.presentador.contratos;

import com.example.dominio.modelo.entidad.Vehiculo;

import java.util.List;

public interface PresentadorPrincipal {

    void obtenerVehiculos ();

    void mostrarVehiculos (List<Vehiculo> vehiculoLista);

    void eliminarVehiculo(Vehiculo vehiculo);

    int obtenerCantidadCarros();

    int obtenerCantidadMotos();

    void ingresarVehiculo (Vehiculo vehiculo);

    int calcularTotal (Vehiculo vehiculo);
}
