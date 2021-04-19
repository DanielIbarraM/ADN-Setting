package com.example.dominio.modelo.paqueadero.CobrarParqueadero;

import com.example.dominio.modelo.entidad.Carro;
import com.example.dominio.modelo.entidad.Vehiculo;
import com.example.dominio.modelo.entidad.parqueadero.Parqueadero;

import org.junit.Before;

import java.util.Calendar;

public class CobrarParqueaderoServicioCarroTest {

    Parqueadero parqueadero;
    Calendar calendar;
    Vehiculo vehiculo;

    @Before
    public void inicializar () {
        parqueadero = new Parqueadero();
        calendar = Calendar.getInstance();
        vehiculo = new Carro("QWE098");
    }

    
}
