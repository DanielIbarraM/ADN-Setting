package com.example.dominio.servicio.contrato;

import com.example.dominio.modelo.entidad.Vehiculo;

import java.util.List;

public interface ContratoMoto {

    int calcularValorTotalMoto (Vehiculo vehiculo);

    List<Vehiculo> obtenerMotos();

    void guardarMoto (Vehiculo vehiculo) throws Exception;

    void eliminarMoto (Vehiculo vehiculo);

    int obtenerCantidadMotos ();

    void validarIngresoMoto (Vehiculo vehiculo) throws Exception;
}
