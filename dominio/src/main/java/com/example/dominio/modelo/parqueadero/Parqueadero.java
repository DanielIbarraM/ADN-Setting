package com.example.dominio.modelo.parqueadero;

import com.example.dominio.excepcionnegocio.FechaSalidaErroneaExcepcion;
import com.example.dominio.excepcionnegocio.PlacaNoPermitidaExcepcion;
import com.example.dominio.excepcionnegocio.PlacaNoValidaExcepcion;
import com.example.dominio.modelo.Carro;
import com.example.dominio.modelo.Moto;
import com.example.dominio.modelo.Vehiculo;
import com.example.dominio.modelo.parqueadero.cobrarparqueadero.CobrarParqueaderoBase;
import com.example.dominio.modelo.parqueadero.cobrarparqueadero.CobrarParqueaderoCarro;
import com.example.dominio.modelo.parqueadero.cobrarparqueadero.CobrarParqueaderoMoto;
import com.example.dominio.modelo.parqueadero.ingresoparqueadero.IngresoParqueadero;

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

    public void validarIngresoVehiculo(Vehiculo vehiculo, Calendar calendar) throws PlacaNoValidaExcepcion, PlacaNoPermitidaExcepcion {
        ingresoParqueadero.validarIngreso(vehiculo, calendar);
    }

    public int calcularTotalVehiculo(Vehiculo vehiculo, Calendar calendar) throws FechaSalidaErroneaExcepcion {
        int total = 0;
        if (vehiculo instanceof Carro) {
            total = cobrarParqueaderoBaseCarro.calcularTotal(vehiculo, calendar);
        }
        if (vehiculo instanceof Moto) {
            total = cobrarParqueaderoBaseMoto.calcularTotal(vehiculo, calendar);
        }
        return total;
    }

    public int obtenerhoraInicialDeCobroPorDia() {
        return horaInicialDeCobroPorDia;
    }

    public int obtenerhorasDelDia() {
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

}
