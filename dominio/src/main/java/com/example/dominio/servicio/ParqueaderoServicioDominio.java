package com.example.dominio.servicio;

import com.example.dominio.modelo.entidad.Parqueadero;
import com.example.dominio.modelo.entidad.Vehiculo;
import com.example.dominio.excepcionNegocio.SinCupoExcepcion;
import com.example.dominio.repositorio.IVehiculoRepositorioPersistencia;
import com.example.dominio.modelo.agregado.cobrarparqueaderoservicio.CobrarParqueaderoCarro;
import com.example.dominio.modelo.agregado.cobrarparqueaderoservicio.CobrarParqueaderoMoto;
import com.example.dominio.modelo.agregado.cobrarparqueaderoservicio.CobrarParqueaderoBase;
import com.example.dominio.modelo.agregado.ingresoParqueaderoServicio.IngresoParqueadero;
import com.example.dominio.servicio.interaceServicio.IParqueaderoServicioDominio;

import java.util.Calendar;
import java.util.List;

public class ParqueaderoServicioDominio implements IParqueaderoServicioDominio {

    CobrarParqueaderoBase cobrarParqueaderoBaseCarro;
    CobrarParqueaderoBase cobrarParqueaderoBaseMoto;
    IVehiculoRepositorioPersistencia carroRepositorio;
    IVehiculoRepositorioPersistencia motoRepositorio;
    IngresoParqueadero ingresoParqueadero;
    Parqueadero parqueadero;

    public ParqueaderoServicioDominio(IVehiculoRepositorioPersistencia carroRepositorio, IVehiculoRepositorioPersistencia motoRepositorio) {
        this.carroRepositorio = carroRepositorio;
        this.motoRepositorio = motoRepositorio;
        parqueadero = Parqueadero.obtenerUnicaInstancia();
        cobrarParqueaderoBaseCarro = new CobrarParqueaderoCarro(parqueadero);
        cobrarParqueaderoBaseMoto = new CobrarParqueaderoMoto(parqueadero);
        ingresoParqueadero = new IngresoParqueadero(parqueadero);
    }

    public void eliminarCarro (Vehiculo vehiculo) {
        carroRepositorio.eliminarVehiculo(vehiculo);
    }

    public void guardarCarro(Vehiculo vehiculo) throws Exception{
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        validarIngresoCarro(vehiculo);
        carroRepositorio.guardarVehiculo(vehiculo);
    }

    @Override
    public int calcularValorTotalCarro(Vehiculo vehiculo) {
        return cobrarParqueaderoBaseCarro.calcularTotal(vehiculo, Calendar.getInstance());
    }

    public List<Vehiculo> obtenerCarros () {
        return carroRepositorio.obtenerVehiculos();
    }

    public int obtenerCantidadCarros() {
        return carroRepositorio.obtenerCantidadVehiculos();
    }

    @Override
    public void validarIngresoCarro(Vehiculo vehiculo) throws Exception{
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

    @Override
    public int calcularValorTotalMoto(Vehiculo vehiculo) {
        return cobrarParqueaderoBaseMoto.calcularTotal(vehiculo, Calendar.getInstance());
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
