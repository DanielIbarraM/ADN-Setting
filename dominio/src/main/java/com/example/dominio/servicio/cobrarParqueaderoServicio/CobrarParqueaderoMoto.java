package com.example.dominio.servicio.cobrarParqueaderoServicio;


import com.example.dominio.entidad.Moto;
import com.example.dominio.entidad.Parqueadero;
import com.example.dominio.entidad.Vehiculo;

import java.util.Calendar;

public class CobrarParqueaderoMoto extends ICobrarParqueadero {

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
        if (obtenerVehiculo() instanceof Moto) {
            if (((Moto) obtenerVehiculo()).obtenerCilindraje() > CilindrajeMinimoPagoExtra) subTotal += valorExtraPorCilindraje;
        }
        return subTotal;
    }



    public int obtenerValorHoraMoto() {
        return valorHoraMoto;
    }

    public int obtenerValorDiaMoto() {
        return valorDiaMoto;
    }

}
