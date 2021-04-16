package com.example.dominio.modelo.entidad.parqueadero.cobrarparqueadero;


import com.example.dominio.modelo.entidad.Moto;
import com.example.dominio.modelo.entidad.Vehiculo;
import com.example.dominio.modelo.entidad.parqueadero.Parqueadero;

import java.util.Calendar;

public class CobrarParqueaderoMoto extends CobrarParqueaderoBase {

    private final int valorHoraMoto = 500;
    private final int valorDiaMoto = 4000;
    private final int CilindrajeMinimoPagoExtra = 500;
    private final int valorExtraPorCilindraje = 2000;

    public CobrarParqueaderoMoto(Parqueadero parqueadero) {
        this.modificarParqueadero(parqueadero);
    }

    @Override
    public int calcularTotal(Vehiculo vehiculo, Calendar fechaSalida) {
        vehiculo.modificarFechaSalida(fechaSalida);
        this.modificarVehiculo(vehiculo);
        int subTotal = cobrarParqueaderoPorVehiculo(obtenerValorHoraMoto(), obtenerValorDiaMoto());
        if (obtenerVehiculo() instanceof Moto && ((Moto) obtenerVehiculo()).obtenerCilindraje() > CilindrajeMinimoPagoExtra) subTotal += valorExtraPorCilindraje;
        return subTotal;
    }

    public int obtenerValorHoraMoto() {
        return valorHoraMoto;
    }

    public int obtenerValorDiaMoto() {
        return valorDiaMoto;
    }

}
