package com.example.dominio.modelo.entidad.parqueadero;

import com.example.dominio.excepcionnegocio.FechaSalidaErronea;
import com.example.dominio.excepcionnegocio.PlacaNoPermitidaExcepcion;
import com.example.dominio.excepcionnegocio.PlacaNoValidaExcepcion;
import com.example.dominio.modelo.entidad.Carro;
import com.example.dominio.modelo.entidad.Moto;
import com.example.dominio.modelo.entidad.Vehiculo;
import com.example.dominio.modelo.entidad.parqueadero.cobrarparqueadero.CobrarParqueaderoBase;
import com.example.dominio.modelo.entidad.parqueadero.cobrarparqueadero.CobrarParqueaderoCarro;
import com.example.dominio.modelo.entidad.parqueadero.cobrarparqueadero.CobrarParqueaderoMoto;
import com.example.dominio.modelo.entidad.parqueadero.ingresoParqueadero.IngresoParqueadero;

import java.util.Calendar;

public class Parqueadero {

    private int horaInicialDeCobroPorDia = 9;
    private int horasDelDia = 24;
    private int cantidadMaximaCarros = 20;
    private int cantidadMaximaMotos = 10;
    private String inicialPlaca = "A";
    private int lunes = 2;
    private int domingo = 1;
    private long horaMilisegundos = 3600000;
    //Valores de estacionamiento

    private final CobrarParqueaderoBase cobrarParqueaderoBaseCarro;
    private final CobrarParqueaderoBase cobrarParqueaderoBaseMoto;
    private IngresoParqueadero ingresoParqueadero;

    public Parqueadero() {
        ingresoParqueadero = new IngresoParqueadero(this);
        cobrarParqueaderoBaseCarro = new CobrarParqueaderoCarro(this);
        cobrarParqueaderoBaseMoto = new CobrarParqueaderoMoto(this);
    }

    public void validarIngresoVehiculo (Vehiculo vehiculo, Calendar calendar) throws PlacaNoValidaExcepcion, PlacaNoPermitidaExcepcion {
        ingresoParqueadero.validarIngreso(vehiculo, calendar);
    }

    public int calcularTotalVehiculo (Vehiculo vehiculo, Calendar calendar) throws FechaSalidaErronea {
        int total = 0;
        if (vehiculo instanceof Carro) total = cobrarParqueaderoBaseCarro.calcularTotal(vehiculo, calendar);
        if (vehiculo instanceof Moto) total = cobrarParqueaderoBaseMoto.calcularTotal(vehiculo, calendar);
        return total;
    }

    public int obtenerhoraInicialDeCobroPorDia() {
        return horaInicialDeCobroPorDia;
    }

    public int obtenerhorasDelDia () {
        return horasDelDia;
    }

    public int obtenerCantidadMaximaCarros() {
        return cantidadMaximaCarros;
    }

    public int obtenerCantidadMaximaMotos() {
        return cantidadMaximaMotos;
    }

    public long obtenerHoraEnMilisegundos() {
        return horaMilisegundos;
    }

    public String obtenerInicialPlaca() {
        return inicialPlaca;
    }

    public int obtenerLunes() {
        return lunes;
    }

    public int obtenerDomingo() {
        return domingo;
    }

    public int obtenerValorHoraCarro() {
        return ((CobrarParqueaderoCarro)cobrarParqueaderoBaseCarro).obtenerValorHoraCarro();
    }

    public int obtenerValorDiaCarro() {
        return ((CobrarParqueaderoCarro)cobrarParqueaderoBaseCarro).obtenerValorDiaCarro();
    }

    public int obtenerValorHoraMoto() {
        return ((CobrarParqueaderoMoto)cobrarParqueaderoBaseMoto).obtenerValorHoraMoto();
    }

    public int obtenerValorDiaMoto() {
        return ((CobrarParqueaderoMoto)cobrarParqueaderoBaseMoto).obtenerValorDiaMoto();
    }



}
