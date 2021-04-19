package com.example.adn_danielibarra.mvp.vista.contratos;

import com.example.dominio.modelo.Vehiculo;

import java.util.List;

public interface VistaParqueadero extends VistaComun {

    void obtenerVehiculos ();

    void mostrarVehiculos (List<Vehiculo> vehiculoLista);

    void mostrarSinVehiculos ();

    void eliminarVehiculo(Vehiculo vehiculo);

    void obtenerCantidadCarros();

    void obtenerCantidadMotos();

    void ingresarVehiculo (Vehiculo vehiculo);


}
