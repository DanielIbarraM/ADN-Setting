package com.example.adn_danielibarra.mvp.presentador.contratos;

import com.example.dominio.modelo.Vehiculo;

import java.util.List;

public interface PresentadorParqueadero {

    void obtenerVehiculos ();

    void mostrarVehiculos (List<Vehiculo> vehiculoLista);

    void eliminarVehiculo(Vehiculo vehiculo);

    int obtenerCantidadCarros();

    int obtenerCantidadMotos();

    void ingresarVehiculo (Vehiculo vehiculo);

    int calcularTotal (Vehiculo vehiculo);
}
