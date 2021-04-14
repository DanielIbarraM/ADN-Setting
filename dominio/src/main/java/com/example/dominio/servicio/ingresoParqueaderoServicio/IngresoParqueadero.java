package com.example.dominio.servicio.ingresoParqueaderoServicio;

import com.example.dominio.entidad.Parqueadero;
import com.example.dominio.entidad.Vehiculo;
import com.example.dominio.excepcionNegocio.PlacaNoPermitidaExcepcion;
import com.example.dominio.excepcionNegocio.PlacaNoValidaExcepcion;

import java.util.Calendar;

public class IngresoParqueadero {

    private Parqueadero parqueadero;

    public IngresoParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public void validarIngreso (Vehiculo vehiculo, Calendar calendar) throws Exception {
        if (vehiculo.obtenerPlaca()==null || vehiculo.obtenerPlaca().isEmpty()){
            throw new PlacaNoValidaExcepcion();
        }
        int diaActual = calendar.get(Calendar.DAY_OF_WEEK);
        if ((vehiculo.obtenerPlaca().toLowerCase().startsWith(parqueadero.obtenerInicialPlaca().toLowerCase())) && (diaActual==parqueadero.DOMINGO || diaActual==parqueadero.LUNES)){
            throw new PlacaNoPermitidaExcepcion();
        }
    }
}
