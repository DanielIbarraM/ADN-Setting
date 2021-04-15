package com.example.dominio.repositorio;

import com.example.dominio.modelo.entidad.Vehiculo;

import java.util.List;

public interface VehiculoRepositorio {

    List<Vehiculo> obtenerVehiculos();

    void guardarVehiculo (Vehiculo vehiculo);

    void eliminarVehiculo (Vehiculo vehiculo);

    int obtenerCantidadVehiculos ();
}
