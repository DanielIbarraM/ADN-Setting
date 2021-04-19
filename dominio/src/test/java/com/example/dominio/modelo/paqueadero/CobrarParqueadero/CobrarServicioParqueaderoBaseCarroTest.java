package com.example.dominio.modelo.paqueadero.CobrarParqueadero;

import com.example.dominio.excepcionnegocio.FechaSalidaErronea;
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
    public void inicializar () {
        parqueadero = new Parqueadero();
        calendar = Calendar.getInstance();
        vehiculo = new Carro("QWE098");
    }

    @Test
    public void calcularTotalCarroConHoraFinalAnteriorAHoraDeSalida (){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*4;
        calendar.setTimeInMillis(calendar.getTimeInMillis()-tiempo);
        //Act
        try {
            int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
            fail();
        } catch (FechaSalidaErronea e) {
            assertEquals(FechaSalidaErronea.class.getName(), e.getClass().getName());
        }
    }

    @Test
    public void calcularTotalCarroConHoraSalidaYLlegadaIguales (){
        //Arrange
        vehiculo.modificarFechaIngreso(calendar);
        //Act
        try {
            int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
            fail();
        } catch (FechaSalidaErronea e) {
            assertEquals(FechaSalidaErronea.class.getName(), e.getClass().getName());
        }
    }

    @Test
    public void calcularTotalCarroConCuatroHorasParqueado (){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*4;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(4000, valorTotal);
    }

    @Test
    public void calcularTotalCarroConSieteHorasParqueado (){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*7;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(7000, valorTotal);
    }

    @Test
    public void calcularTotalCarroConOchoHorasParqueado (){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*8;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(8000, valorTotal);
    }

    @Test
    public void calcularTotalCarroConNueveHorasParqueadoCobroPorDia (){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*9;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(8000, valorTotal);
    }

    @Test
    public void calcularTotalCarroConVeinteHorasParqueadoCobroPorDia (){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*20;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(8000, valorTotal);
    }

    @Test
    public void calcularTotalCarroConVeinteSeisHorasParqueadoCobroPorDia (){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*26;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(10000, valorTotal);
    }

    @Test
    public void calcularTotalCarroConSetentaYCincoHorasParqueadoCobroPorDia (){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*75;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(27000, valorTotal);
    }
}
