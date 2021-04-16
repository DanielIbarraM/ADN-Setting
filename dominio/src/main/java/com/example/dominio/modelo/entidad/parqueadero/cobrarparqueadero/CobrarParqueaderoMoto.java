package com.example.dominio.modelo.entidad.parqueadero.cobrarparqueadero;


import com.example.dominio.modelo.entidad.Moto;
import com.example.dominio.modelo.entidad.Vehiculo;
import com.example.dominio.modelo.entidad.parqueadero.Parqueadero;

import java.util.Calendar;

public class CobrarParqueaderoMoto extends CobrarParqueaderoBase {

    private static final int VALOR_HORA_MOTO = 500;
    private static final int VALOR_DIA_MOTO = 4000;
    private static final int CILINDRAJE_MINIMO_PAGO_EXTRA = 500;
    private static final int VALOR_EXTRA_POR_CILINDRAJE = 2000;

    public CobrarParqueaderoMoto(Parqueadero parqueadero) {
        this.modificarParqueadero(parqueadero);
    }

    @Override
    public int calcularTotal(Vehiculo vehiculo, Calendar fechaSalida) {
        vehiculo.modificarFechaSalida(fechaSalida);
        this.modificarVehiculo(vehiculo);
        int subTotal = cobrarParqueaderoPorVehiculo(obtenerValorHoraMoto(), obtenerValorDiaMoto());
        if (((Moto)vehiculo).obtenerCilindraje() > CILINDRAJE_MINIMO_PAGO_EXTRA) {
            subTotal += VALOR_EXTRA_POR_CILINDRAJE;
        }
        return subTotal;
    }

    public int obtenerValorHoraMoto() {
        return VALOR_HORA_MOTO;
    }

    public int obtenerValorDiaMoto() {
        return VALOR_DIA_MOTO;
    }

}
