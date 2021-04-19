package com.example.adn_danielibarra.mvp.modelo.contrato;

import com.example.dominio.modelo.Vehiculo;

public interface RepositorioParqueadero {

    void obtenerVehiculos ();

    void eliminarVehiculo(Vehiculo vehiculo);

    int obtenerCantidadCarros();

    int obtenerCantidadMotos();

    void ingresarVehiculo (Vehiculo vehiculo);

    int calcularTotalVehiculo (Vehiculo vehiculo);
}
