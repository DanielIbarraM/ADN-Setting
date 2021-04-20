package com.example.dominio.repositorio;

import com.example.dominio.modelo.Vehiculo;

import java.util.List;

public interface VehiculoRepositorio {

    List<Vehiculo> obtenerVehiculos();

    void guardarVehiculo(Vehiculo vehiculo);

    void eliminarVehiculo(Vehiculo vehiculo);

    int obtenerCantidadVehiculos();

    Vehiculo obtenerVehiculo (String placa);
}
