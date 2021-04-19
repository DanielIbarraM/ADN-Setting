package com.example.dominio.modelo.paqueadero.CobrarParqueadero;

import com.example.dominio.excepcionnegocio.FechaSalidaErroneaExcepcion;
import com.example.dominio.modelo.Carro;
import com.example.dominio.modelo.Vehiculo;
import com.example.dominio.modelo.parqueadero.Parqueadero;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CobrarServicioParqueaderoBaseCarroTest {

    Parqueadero parqueadero;
    Calendar calendar;
    Vehiculo vehiculo;

    @Before
    public void inicializar() {
        parqueadero = new Parqueadero();
        calendar = Calendar.getInstance();
        vehiculo = new Carro("QWE098");
    }

    @Test
    public void calcularTotal_calcularTotalCarroConHoraFinalAnteriorAHoraDeSalida_devuelveFechaSalidaErroneaExcepcion() {
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos() * 4;
        calendar.setTimeInMillis(calendar.getTimeInMillis() - tiempo);
        //Act
        try {
            parqueadero.calcularTotalVehiculo(vehiculo, calendar);
            fail();
        } catch (FechaSalidaErroneaExcepcion e) {
            //Assert
            assertEquals(new FechaSalidaErroneaExcepcion().getMessage(), e.getMessage());
        }
    }

    @Test
    public void calcularTotal_calcularTotalCarroConHoraSalidaYLlegadaIguales_devuelveFechaSalidaErroneaExcepcion() {
        //Arrange
        vehiculo.modificarFechaIngreso(calendar);
        //Act
        try {
            parqueadero.calcularTotalVehiculo(vehiculo, calendar);
            fail();
        } catch (FechaSalidaErroneaExcepcion e) {
            //Assert
            assertEquals(new FechaSalidaErroneaExcepcion().getMessage(), e.getMessage());
        }
    }

    @Test
    public void calcularTotal_calcularTotalCarroConCuatroHorasParqueado_exitosoValoresIguales() {
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos() * 4;
        calendar.setTimeInMillis(calendar.getTimeInMillis() + tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(4000, valorTotal);
    }

    @Test
    public void calcularTotal_calcularTotalCarroConSieteHorasParqueado_exitosoValoresIguales() {
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos() * 7;
        calendar.setTimeInMillis(calendar.getTimeInMillis() + tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(7000, valorTotal);
    }

    @Test
    public void calcularTotal_calcularTotalCarroConOchoHorasParqueado_exitosoValoresIguales() {
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos() * 8;
        calendar.setTimeInMillis(calendar.getTimeInMillis() + tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(8000, valorTotal);
    }

    @Test
    public void calcularTotal_calcularTotalCarroConNueveHorasParqueadoCobroPorDia_exitosoValoresIguales() {
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos() * 9;
        calendar.setTimeInMillis(calendar.getTimeInMillis() + tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(8000, valorTotal);
    }

    @Test
    public void calcularTotal_calcularTotalCarroConVeinteHorasParqueadoCobroPorDia_exitosoValoresIguales() {
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos() * 20;
        calendar.setTimeInMillis(calendar.getTimeInMillis() + tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(8000, valorTotal);
    }

    @Test
    public void calcularTotal_calcularTotalCarroConVeinteSeisHorasParqueadoCobroPorDia_exitosoValoresIguales() {
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos() * 26;
        calendar.setTimeInMillis(calendar.getTimeInMillis() + tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(10000, valorTotal);
    }

    @Test
    public void calcularTotal_calcularTotalCarroConSetentaYCincoHorasParqueadoCobroPorDia_exitosoValoresIguales() {
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos() * 75;
        calendar.setTimeInMillis(calendar.getTimeInMillis() + tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(27000, valorTotal);
    }
}
