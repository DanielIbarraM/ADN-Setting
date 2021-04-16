package com.example.adn_danielibarra.mvp.vista.contratos;

import com.example.dominio.modelo.entidad.Vehiculo;

import java.util.List;

public interface VistaPrincipal extends VistaGeneral{

    void obtenerVehiculos ();

    void mostrarVehiculos (List<Vehiculo> vehiculoLista);

    void mostrarSinVehiculos ();

    void eliminarVehiculo(Vehiculo vehiculo);

    void obtenerCantidadCarros();

    void obtenerCantidadMotos();

    void ingresarVehiculo (Vehiculo vehiculo);


}