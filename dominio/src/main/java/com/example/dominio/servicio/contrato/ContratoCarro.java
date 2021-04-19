package com.example.dominio.servicio.contrato;

import com.example.dominio.modelo.Vehiculo;

import java.util.List;

public interface ContratoCarro {

    List<Vehiculo> obtenerCarros();

    void guardarCarro(Vehiculo vehiculo);

    void eliminarCarro(Vehiculo vehiculo);

    int obtenerCantidadCarros();

    void validarIngresoCarro(Vehiculo vehiculo);

}
