package com.example.dominio.servicio.interaceServicio;

import com.example.dominio.entidad.Vehiculo;

import java.util.Calendar;
import java.util.List;

public interface IMotoServicio {

    int calcularValorTotalMoto (Vehiculo vehiculo);

    List<Vehiculo> obtenerMotos();

    void guardarMoto (Vehiculo vehiculo) throws Exception;

    void eliminarMoto (Vehiculo vehiculo);

    int obtenerCantidadMotos ();

    void validarIngresoMoto (Vehiculo vehiculo) throws Exception;
}
