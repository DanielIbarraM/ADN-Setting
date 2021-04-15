package com.example.dominio.modelo.agregado.ingresoParqueaderoServicio;

import com.example.dominio.modelo.entidad.Parqueadero;
import com.example.dominio.modelo.entidad.Vehiculo;
import com.example.dominio.excepcionnegocio.PlacaNoPermitidaExcepcion;
import com.example.dominio.excepcionnegocio.PlacaNoValidaExcepcion;

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
