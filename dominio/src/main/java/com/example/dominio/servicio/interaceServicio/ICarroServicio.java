package com.example.dominio.servicio.interaceServicio;

import com.example.dominio.modelo.entidad.Vehiculo;

import java.util.List;

public interface ICarroServicio {

    int calcularValorTotalCarro (Vehiculo vehiculo);

    List<Vehiculo> obtenerCarros();

    void guardarCarro (Vehiculo vehiculo) throws Exception;

    void eliminarCarro (Vehiculo vehiculo);

    int obtenerCantidadCarros();

    void validarIngresoCarro (Vehiculo vehiculo) throws Exception;

}
