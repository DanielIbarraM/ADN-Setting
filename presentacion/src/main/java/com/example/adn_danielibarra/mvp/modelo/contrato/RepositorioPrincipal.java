package com.example.adn_danielibarra.mvp.modelo.contrato;

import com.example.dominio.modelo.entidad.Vehiculo;

public interface RepositorioPrincipal {

    void obtenerVehiculos ();

    void eliminarVehiculo(Vehiculo vehiculo);

    int obtenerCantidadCarros();

    int obtenerCantidadMotos();

    void ingresarVehiculo (Vehiculo vehiculo);
}
