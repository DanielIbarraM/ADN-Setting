package com.example.dominio.servicio.CobrarParqueadero;

import com.example.dominio.modelo.entidad.Carro;
import com.example.dominio.modelo.entidad.Parqueadero;
import com.example.dominio.modelo.entidad.Vehiculo;
import com.example.dominio.modelo.agregado.cobrarParqueaderoServicio.CobrarParqueaderoCarro;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class CobrarParqueaderoCarroTest {

    Parqueadero parqueadero;
    CobrarParqueaderoCarro cobrarParqueaderoCarro;
    Calendar calendar;
    Vehiculo vehiculo;

    @Before
    public void inicializar () {
        parqueadero = Parqueadero.obtenerUnicaInstancia();
        cobrarParqueaderoCarro = new CobrarParqueaderoCarro(parqueadero);
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
        int valorTotal = cobrarParqueaderoCarro.calcularTotal(vehiculo, calendar);
        //Assert
        assertEquals(1000, valorTotal);
    }

    @Test
    public void calcularTotalCarroConHoraSalidaYLlegadaIguales (){
        //Arrange
        vehiculo.modificarFechaIngreso(calendar);
        //Act
        int valorTotal = cobrarParqueaderoCarro.calcularTotal(vehiculo, calendar);
        //Assert
        assertEquals(1000, valorTotal);
    }

    @Test
    public void calcularTotalCarroConCuatroHorasParqueado (){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*4;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = cobrarParqueaderoCarro.calcularTotal(vehiculo, calendar);
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
        int valorTotal = cobrarParqueaderoCarro.calcularTotal(vehiculo, calendar);
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
        int valorTotal = cobrarParqueaderoCarro.calcularTotal(vehiculo, calendar);
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
        int valorTotal = cobrarParqueaderoCarro.calcularTotal(vehiculo, calendar);
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
        int valorTotal = cobrarParqueaderoCarro.calcularTotal(vehiculo, calendar);
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
        int valorTotal = cobrarParqueaderoCarro.calcularTotal(vehiculo, calendar);
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
        int valorTotal = cobrarParqueaderoCarro.calcularTotal(vehiculo, calendar);
        //Assert
        assertEquals(27000, valorTotal);
    }
}
