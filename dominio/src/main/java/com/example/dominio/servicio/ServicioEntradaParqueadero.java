package com.example.dominio.servicio;

import com.example.dominio.excepcionnegocio.SinCupoExcepcion;
import com.example.dominio.modelo.Vehiculo;
import com.example.dominio.modelo.parqueadero.Parqueadero;
import com.example.dominio.repositorio.VehiculoRepositorio;

import java.util.Calendar;
import java.util.List;

public class ServicioEntradaParqueadero {

    VehiculoRepositorio carroRepositorio;
    VehiculoRepositorio motoRepositorio;
    Parqueadero parqueadero;

    public ServicioEntradaParqueadero(VehiculoRepositorio carroRepositorio, VehiculoRepositorio motoRepositorio, Parqueadero parqueadero) {
        this.carroRepositorio = carroRepositorio;
        this.motoRepositorio = motoRepositorio;
        this.parqueadero = parqueadero;
    }

    public void guardarMoto (Vehiculo vehiculo){
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        validarIngresoMoto(vehiculo);
        motoRepositorio.guardarVehiculo(vehiculo);
    }

    public int obtenerCantidadMotos (){
        return motoRepositorio.obtenerCantidadVehiculos();
    }

    public List<Vehiculo> obtenerMotos() {
        return motoRepositorio.obtenerVehiculos();
    }

    public void validarIngresoMoto (Vehiculo vehiculo) {
        if ((obtenerCantidadMotos()>=parqueadero.obtenerCantidadMaximaMotos())){
            throw new SinCupoExcepcion();
        }

        parqueadero.validarIngresoVehiculo(vehiculo, Calendar.getInstance());
    }

    public void guardarCarro (Vehiculo vehiculo){
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        validarIngresoCarro(vehiculo);
        carroRepositorio.guardarVehiculo(vehiculo);
    }

    public int obtenerCantidadCarros (){
        return carroRepositorio.obtenerCantidadVehiculos();
    }

    public List<Vehiculo> obtenerCarros() {
        return carroRepositorio.obtenerVehiculos();
    }

    public void validarIngresoCarro (Vehiculo vehiculo) {
        if ((obtenerCantidadCarros()>=parqueadero.obtenerCantidadMaximaCarros())){
            throw new SinCupoExcepcion();
        }

        parqueadero.validarIngresoVehiculo(vehiculo, Calendar.getInstance());
    }

}
