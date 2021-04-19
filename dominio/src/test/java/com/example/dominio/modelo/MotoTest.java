package com.example.dominio.modelo;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class MotoTest {

    @Test
    public void validarPlacaConValorNulo () {
        //Arrange
        Vehiculo vehiculo = null;
        //Act
        vehiculo = new Moto(null, 0);
        //Assert
        assertNull(vehiculo.obtenerPlaca());
    }

    @Test
    public void validarFechaIngresoNoNulo () {
        //Arrange
        Vehiculo vehiculo = new Moto("Qwe012",0);
        //Act
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        //Assert
        assertNotNull(vehiculo.obtenerFechaIngreso());
    }

    @Test
    public void validarNoAlteracionesEnFechaIngreso () {
        //Arrange
        Vehiculo vehiculo = new Moto("ZXC012", 0);
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
        Vehiculo vehiculo = new Moto("Qwe012", 0);
        //Act
        vehiculo.modificarFechaSalida(Calendar.getInstance());
        //Assert
        assertNotNull(vehiculo.obtenerFechaSalida());
    }

    @Test
    public void validarNoAlteracionesEnFechaSalida () {
        //Arrange
        Vehiculo vehiculo = new Moto("ZXC012",0);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,03,14);
        //Act
        vehiculo.modificarFechaSalida(calendar);
        //Assert
        assertEquals(calendar.getTimeInMillis(), vehiculo.obtenerFechaSalida().getTimeInMillis());
    }

    @Test
    public void validarNoAlteracionesEnCilindraje () {
        //Arrange
        Moto moto;
        //Act
        moto = new Moto("ZXC012",550);
        //Assert
        assertEquals(550, moto.obtenerCilindraje());
    }
}
