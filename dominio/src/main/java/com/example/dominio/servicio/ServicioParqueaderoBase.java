package com.example.dominio.servicio;

import com.example.dominio.excepcionnegocio.FechaSalidaErroneaExcepcion;
import com.example.dominio.modelo.Vehiculo;
import com.example.dominio.modelo.parqueadero.Parqueadero;
import com.example.dominio.repositorio.VehiculoRepositorio;
import com.example.dominio.servicio.contrato.ContratoParqueadero;

import java.util.Calendar;
import java.util.List;

public class ServicioParqueaderoBase implements ContratoParqueadero {

    Parqueadero parqueadero;
    ServicioEntradaParqueadero servicioEntradaParqueadero;
    ServicioSalidaParqueadero servicioSalidaParqueadero;

    public ServicioParqueaderoBase(VehiculoRepositorio carroRepositorio, VehiculoRepositorio motoRepositorio) {
        parqueadero = new Parqueadero();
        servicioEntradaParqueadero = new ServicioEntradaParqueadero(carroRepositorio, motoRepositorio, parqueadero);
        servicioSalidaParqueadero = new ServicioSalidaParqueadero(carroRepositorio, motoRepositorio, parqueadero);
    }

    public void eliminarCarro(Vehiculo vehiculo) {
        servicioSalidaParqueadero.eliminarCarro(vehiculo);
    }

    public void guardarCarro(Vehiculo vehiculo) {
        servicioEntradaParqueadero.guardarCarro(vehiculo);
    }

    @Override
    public int calcularValorTotal(Vehiculo vehiculo) throws FechaSalidaErroneaExcepcion {
        return parqueadero.calcularTotalVehiculo(vehiculo, Calendar.getInstance());
    }

    public List<Vehiculo> obtenerCarros() {
        return servicioEntradaParqueadero.obtenerCarros();
    }

    public int obtenerCantidadCarros() {
        return servicioEntradaParqueadero.obtenerCantidadCarros();
    }

    @Override
    public void validarIngresoCarro(Vehiculo vehiculo) {
        servicioEntradaParqueadero.validarIngresoCarro(vehiculo);

    }

    public void eliminarMoto(Vehiculo vehiculo) {
        servicioSalidaParqueadero.eliminarMoto(vehiculo);
    }

    public void guardarMoto(Vehiculo vehiculo) {
        servicioEntradaParqueadero.guardarMoto(vehiculo);
    }

    public List<Vehiculo> obtenerMotos() {
        return servicioEntradaParqueadero.obtenerMotos();
    }

    public int obtenerCantidadMotos() {
        return servicioEntradaParqueadero.obtenerCantidadMotos();
    }

    @Override
    public void validarIngresoMoto(Vehiculo vehiculo) {
        servicioEntradaParqueadero.validarIngresoMoto(vehiculo);
    }
}
