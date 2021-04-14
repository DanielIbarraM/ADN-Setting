package com.example.dominio.servicio.ingresoParqueadero;

import com.example.dominio.entidad.Carro;
import com.example.dominio.entidad.Parqueadero;
import com.example.dominio.servicio.ingresoParqueaderoServicio.IngresoParqueadero;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class IngresoParqueaderoTest {

    Parqueadero parqueadero;
    IngresoParqueadero ingresoParqueadero;

    @Before
    public void inicializar () {
        parqueadero = Parqueadero.obtenerUnicaInstancia();
        ingresoParqueadero = new IngresoParqueadero(parqueadero);
    }

    @Test
    public void validarIngresoVehiculoPlacaMayusculaSinInicialADiaMiercoles () {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,03,14);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("QWERTY"), calendar);
        }catch (Exception e){
            fail();
        }
        //Assert

    }

    @Test
    public void validarIngresoVehiculoPlacaMayusculaSinInicialADiaDomingo () {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,03,11);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("QWERTY"), calendar);
        }catch (Exception e){
            fail();
        }
        //Assert
    }

    @Test
    public void validarIngresoVehiculoPlacaMayusculaConInicialADiaDomingo () {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,03,11);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("AWERTY"), calendar);
            fail();
        }catch (Exception e){
        }
        //Assert
    }

    @Test
    public void validarIngresoVehiculoPlacaMayusculaConInicialADiaLunes () {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,03,12);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("AWERTY"), calendar);
            fail();
        }catch (Exception e){
        }
        //Assert
    }

    @Test
    public void validarIngresoVehiculoPlacaMayusculaConInicialADiaMartes () {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,03,13);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("AWERTY"), calendar);
        }catch (Exception e){
            fail();
        }
        //Assert
    }

    @Test
    public void validarIngresoVehiculoPlacaMinusculaConInicialADiaDomingo () {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,03,11);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("awerty"), calendar);
            fail();
        }catch (Exception e){
        }
        //Assert
    }

    @Test
    public void validarIngresoVehiculoPlacaMinusculaConInicialADiaLunes () {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,03,12);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("awertyy"), calendar);
            fail();
        }catch (Exception e){
        }
        //Assert
    }

    @Test
    public void validarIngresoVehiculoPlacaMinusculaConInicialADiaMartes () {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,03,13);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("awerty"), calendar);
        }catch (Exception e){
            fail();
        }
        //Assert
    }

    @Test
    public void validarIngresoVehiculoPlacaMayusculaConInicialADiaViernes () {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,03,16);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("AWERTY"), calendar);
        }catch (Exception e){
            fail();
        }
        //Assert
    }
}
