package com.example.dominio.modelo.entidad.parqueadero.cobrarparqueadero;


import com.example.dominio.excepcionnegocio.FechaSalidaErronea;
import com.example.dominio.modelo.entidad.Vehiculo;
import com.example.dominio.modelo.entidad.parqueadero.Parqueadero;

import java.util.Calendar;

public class CobrarParqueaderoCarro extends CobrarParqueaderoBase {

    private final int valorHoraCarro = 1000;
    private final int valorDiaCarro = 8000;

    public CobrarParqueaderoCarro(Parqueadero parqueadero) {
        this.modificarParqueadero(parqueadero);
    }

    @Override
    public int calcularTotal(Vehiculo vehiculo, Calendar fechaSalida) throws FechaSalidaErronea {
        vehiculo.modificarFechaSalida(fechaSalida);
        this.modificarVehiculo(vehiculo);
        return cobrarParqueaderoPorVehiculo(obtenerValorHoraCarro(), obtenerValorDiaCarro());
    }

    public int obtenerValorHoraCarro() {
        return valorHoraCarro;
    }

    public int obtenerValorDiaCarro() {
        return valorDiaCarro;
    }
}