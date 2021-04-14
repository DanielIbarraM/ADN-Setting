package com.example.dominio.repositorio;

import com.example.dominio.entidad.Vehiculo;

import java.util.List;

public interface IVehiculoRepositorioPersistencia {

    List<Vehiculo> obtenerVehiculos();

    void guardarVehiculo (Vehiculo vehiculo);

    void eliminarVehiculo (Vehiculo vehiculo);

    int obtenerCantidadVehiculos ();
}
