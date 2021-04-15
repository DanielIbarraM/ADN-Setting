package com.example.dominio.servicio;

import com.example.dominio.modelo.entidad.Parqueadero;
import com.example.dominio.modelo.entidad.Vehiculo;
import com.example.dominio.excepcionNegocio.SinCupoExcepcion;
import com.example.dominio.repositorio.IVehiculoRepositorioPersistencia;
import com.example.dominio.modelo.agregado.cobrarParqueaderoServicio.CobrarParqueaderoCarro;
import com.example.dominio.modelo.agregado.cobrarParqueaderoServicio.CobrarParqueaderoMoto;
import com.example.dominio.modelo.agregado.cobrarParqueaderoServicio.ICobrarParqueadero;
import com.example.dominio.modelo.agregado.ingresoParqueaderoServicio.IngresoParqueadero;
import com.example.dominio.servicio.interaceServicio.IParqueaderoServicioDominio;

import java.util.Calendar;
import java.util.List;

public class ParqueaderoServicioDominio implements IParqueaderoServicioDominio {

    ICobrarParqueadero iCobrarParqueaderoCarro;
    ICobrarParqueadero iCobrarParqueaderoMoto;
    IVehiculoRepositorioPersistencia carroRepositorio;
    IVehiculoRepositorioPersistencia motoRepositorio;
    IngresoParqueadero ingresoParqueadero;
    Parqueadero parqueadero;

    public ParqueaderoServicioDominio(IVehiculoRepositorioPersistencia carroRepositorio, IVehiculoRepositorioPersistencia motoRepositorio) {
        this.carroRepositorio = carroRepositorio;
        this.motoRepositorio = motoRepositorio;
        parqueadero = Parqueadero.obtenerUnicaInstancia();
        iCobrarParqueaderoCarro = new CobrarParqueaderoCarro(parqueadero);
        iCobrarParqueaderoMoto = new CobrarParqueaderoMoto(parqueadero);
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
        return iCobrarParqueaderoCarro.calcularTotal(vehiculo, Calendar.getInstance());
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
        return iCobrarParqueaderoMoto.calcularTotal(vehiculo, Calendar.getInstance());
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
