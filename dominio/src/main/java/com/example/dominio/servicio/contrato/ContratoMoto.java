package com.example.dominio.servicio.contrato;

import com.example.dominio.modelo.Vehiculo;

import java.util.List;

public interface ContratoMoto {

    List<Vehiculo> obtenerMotos();

    void guardarMoto (Vehiculo vehiculo);

    void eliminarMoto (Vehiculo vehiculo);

    int obtenerCantidadMotos ();

    void validarIngresoMoto (Vehiculo vehiculo);
}
