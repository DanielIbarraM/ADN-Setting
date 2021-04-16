package com.example.dominio.modelo.entidad.parqueadero.cobrarparqueadero;


import com.example.dominio.excepcionnegocio.FechaSalidaErronea;
import com.example.dominio.modelo.entidad.Vehiculo;
import com.example.dominio.modelo.entidad.parqueadero.Parqueadero;

import java.util.Calendar;

public class CobrarParqueaderoCarro extends CobrarParqueaderoBase {

    private static final int VALOR_HORA_CARRO = 1000;
    private static final int VALOR_DIA_CARRO = 8000;

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
        return VALOR_HORA_CARRO;
    }

    public int obtenerValorDiaCarro() {
        return VALOR_DIA_CARRO;
    }
}
