package com.example.dominio.modelo.parqueadero.cobrarparqueadero;


import com.example.dominio.excepcionnegocio.FechaSalidaErronea;
import com.example.dominio.modelo.Vehiculo;
import com.example.dominio.modelo.parqueadero.Parqueadero;

import java.util.Calendar;

public abstract class CobrarParqueaderoBase {

    private Vehiculo vehiculo;
    private Parqueadero parqueadero;

    private int calcularTotalHorasPorVehiculo(){
        long diferenciaHoras = obtenerVehiculo().obtenerFechaSalida().getTimeInMillis() - vehiculo.obtenerFechaIngreso().getTimeInMillis();
        float resultado = (float) diferenciaHoras/parqueadero.obtenerHoraEnMilisegundos();
        return (int) Math.ceil(resultado);
    }

    private void verificarFechaSalidaPosteriorFechaEntrada () throws FechaSalidaErronea {
        if (obtenerVehiculo().obtenerFechaSalida().compareTo(obtenerVehiculo().obtenerFechaIngreso()) <= 0){
            throw new FechaSalidaErronea();
        }
    }

    protected int cobrarParqueaderoPorVehiculo(int valorPorHora, int valorPorDia) throws FechaSalidaErronea {
        int horasParqueadas;
        int valorPagar = 0;

        verificarFechaSalidaPosteriorFechaEntrada();
        horasParqueadas = calcularTotalHorasPorVehiculo();

        if (horasParqueadas < parqueadero.obtenerhoraInicialDeCobroPorDia()) {
            valorPagar = horasParqueadas * valorPorHora;
        }

        if (horasParqueadas >= parqueadero.obtenerhoraInicialDeCobroPorDia() && horasParqueadas <= parqueadero.obtenerhorasDelDia()) {
            valorPagar = valorPorDia;
        }

        if (horasParqueadas > parqueadero.obtenerhorasDelDia()) {
            int dias = horasParqueadas / parqueadero.obtenerhorasDelDia();
            int horas = horasParqueadas % parqueadero.obtenerhorasDelDia();
            if (horas>=parqueadero.obtenerhoraInicialDeCobroPorDia())
                valorPagar = (dias + 1) * valorPorDia;
            else
                valorPagar = (dias * valorPorDia) + (horas * valorPorHora);
        }

        return valorPagar;
    }

    public abstract int calcularTotal (Vehiculo vehiculo, Calendar fechaSalida);

    protected Vehiculo obtenerVehiculo() {
        return vehiculo;
    }

    protected void modificarVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    protected void modificarParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    protected Parqueadero obtenerParqueadero () {
        return parqueadero;
    }
}
