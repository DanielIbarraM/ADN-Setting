package com.example.dominio.servicio;

import com.example.dominio.excepcionnegocio.FechaSalidaErronea;
import com.example.dominio.excepcionnegocio.SinCupoExcepcion;
import com.example.dominio.modelo.entidad.Vehiculo;
import com.example.dominio.modelo.entidad.parqueadero.Parqueadero;
import com.example.dominio.modelo.entidad.parqueadero.ingresoParqueadero.IngresoParqueadero;
import com.example.dominio.repositorio.VehiculoRepositorio;
import com.example.dominio.servicio.contrato.ContratoParqueadero;

import java.util.Calendar;
import java.util.List;

public class ParqueaderoServicio implements ContratoParqueadero {

    VehiculoRepositorio carroRepositorio;
    VehiculoRepositorio motoRepositorio;
    IngresoParqueadero ingresoParqueadero;
    Parqueadero parqueadero;

    public ParqueaderoServicio(VehiculoRepositorio carroRepositorio, VehiculoRepositorio motoRepositorio) {
        this.carroRepositorio = carroRepositorio;
        this.motoRepositorio = motoRepositorio;
        parqueadero = new Parqueadero();
        ingresoParqueadero = new IngresoParqueadero(parqueadero);
    }

    public void eliminarCarro (Vehiculo vehiculo) {
        carroRepositorio.eliminarVehiculo(vehiculo);
    }

    public void guardarCarro(Vehiculo vehiculo) {
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        validarIngresoCarro(vehiculo);
        carroRepositorio.guardarVehiculo(vehiculo);
    }

    @Override
    public int calcularValorTotal (Vehiculo vehiculo) throws FechaSalidaErronea {
        return parqueadero.calcularTotalVehiculo(vehiculo, Calendar.getInstance());
    }

    public List<Vehiculo> obtenerCarros () {
        return carroRepositorio.obtenerVehiculos();
    }

    public int obtenerCantidadCarros() {
        return carroRepositorio.obtenerCantidadVehiculos();
    }

    @Override
    public void validarIngresoCarro(Vehiculo vehiculo) {
        if ((obtenerCantidadCarros()>=parqueadero.obtenerCantidadMaximaCarros())){
            throw new SinCupoExcepcion();
        }

        ingresoParqueadero.validarIngreso(vehiculo, Calendar.getInstance());

    }

    public void eliminarMoto (Vehiculo vehiculo) {
        motoRepositorio.eliminarVehiculo(vehiculo);
    }

    public void guardarMoto(Vehiculo vehiculo) throws Exception{
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        validarIngresoMoto(vehiculo);
        motoRepositorio.guardarVehiculo(vehiculo);
    }

    public List<Vehiculo> obtenerMotos () {
        return motoRepositorio.obtenerVehiculos();
    }

    public int obtenerCantidadMotos () {
        return motoRepositorio.obtenerCantidadVehiculos();
    }

    @Override
    public void validarIngresoMoto(Vehiculo vehiculo) throws Exception {

        if ((obtenerCantidadMotos()>=parqueadero.obtenerCantidadMaximaMotos())){
            throw new SinCupoExcepcion();
        }


        ingresoParqueadero.validarIngreso(vehiculo, Calendar.getInstance());
    }
}
