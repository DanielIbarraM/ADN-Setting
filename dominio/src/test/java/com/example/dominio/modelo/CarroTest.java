package com.example.dominio.modelo;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class CarroTest {

    @Test
    public void validarPlacaConValorNulo () {
        //Arrange
        Vehiculo vehiculo = null;
        //Act
        vehiculo = new Carro(null);
        //Assert
        assertNull(vehiculo.obtenerPlaca());
    }

    @Test
    public void validarNoAlteracionesEnPlaca () {
        //Arrange
        Vehiculo vehiculo = null;
        //Act
        vehiculo = new Carro("QWERTY");
        //Assert
        assertEquals("QWERTY", vehiculo.obtenerPlaca());
    }

    @Test
    public void validarFechaIngresoNoNulo () {
        //Arrange
        Vehiculo vehiculo = new Carro("Qwe012");
        //Act
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        //Assert
        assertNotNull(vehiculo.obtenerFechaIngreso());
    }

    @Test
    public void validarNoAlteracionesEnFechaIngreso () {
        //Arrange
        Vehiculo vehiculo = new Carro("ZXC012");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,03,14);
        //Act
        vehiculo.modificarFechaIngreso(calendar);
        //Assert
        assertEquals(calendar.getTimeInMillis(), vehiculo.obtenerFechaIngreso().getTimeInMillis());
    }

    @Test
    public void validarFechaSalidaNoNulo () {
        //Arrange
        Vehiculo vehiculo = new Carro("Qwe012");
        //Act
        vehiculo.modificarFechaSalida(Calendar.getInstance());
        //Assert
        assertNotNull(vehiculo.obtenerFechaSalida());
    }

    @Test
    public void validarNoAlteracionesEnFechaSalida () {
        //Arrange
        Vehiculo vehiculo = new Carro("ZXC012");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,03,14);
        //Act
        vehiculo.modificarFechaSalida(calendar);
        //Assert
        assertEquals(calendar.getTimeInMillis(), vehiculo.obtenerFechaSalida().getTimeInMillis());
    }

}
