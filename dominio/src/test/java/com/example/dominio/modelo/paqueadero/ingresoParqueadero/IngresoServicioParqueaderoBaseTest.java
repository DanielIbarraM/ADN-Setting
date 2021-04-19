package com.example.dominio.modelo.paqueadero.ingresoParqueadero;

import com.example.dominio.excepcionnegocio.PlacaNoPermitidaExcepcion;
import com.example.dominio.modelo.Carro;
import com.example.dominio.modelo.parqueadero.Parqueadero;
import com.example.dominio.modelo.parqueadero.ingresoparqueadero.IngresoParqueadero;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class IngresoServicioParqueaderoBaseTest {

    Parqueadero parqueadero;
    IngresoParqueadero ingresoParqueadero;

    @Before
    public void inicializar() {
        parqueadero = new Parqueadero();
        ingresoParqueadero = new IngresoParqueadero(parqueadero);
    }

    @Test
    public void validarIngreso_validarIngresoVehiculoPlacaMayusculaSinInicialADiaMiercoles_exitosoNoDebeEntrarAlCatch() {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 03, 14);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("QWERTY"), calendar);
        } catch (Exception e) {
            fail();
        }
        //Assert

    }

    @Test
    public void validarIngreso_validarIngresoVehiculoPlacaMayusculaSinInicialADiaDomingo_exitosoNoDebeEntrarAlCatch() {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 03, 11);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("QWERTY"), calendar);
        } catch (Exception e) {
            fail();
        }
        //Assert
    }

    @Test
    public void validarIngreso_validarIngresoVehiculoPlacaMayusculaConInicialADiaDomingo_exitosoDebeDevolverPlacanoPermitidaExcepcion() {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 03, 11);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("AWERTY"), calendar);
            fail();
        } catch (PlacaNoPermitidaExcepcion e) {
            //Assert
            assertEquals(new PlacaNoPermitidaExcepcion().getMessage(), e.getMessage());
        }

    }

    @Test
    public void validarIngreso_validarIngresoVehiculoPlacaMayusculaConInicialADiaLunes_exitosoDebeDevolverPlacanoPermitidaExcepcion() {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 03, 12);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("AWERTY"), calendar);
            fail();
        } catch (PlacaNoPermitidaExcepcion e) {
            //Assert
            assertEquals(new PlacaNoPermitidaExcepcion().getMessage(), e.getMessage());
        }
    }

    @Test
    public void validarIngreso_validarIngresoVehiculoPlacaMayusculaConInicialADiaMartes_exitosoNoDebeEntrarAlCatch() {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 03, 13);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("AWERTY"), calendar);
        } catch (Exception e) {
            fail();
        }
        //Assert
    }

    @Test
    public void validarIngreso_validarIngresoVehiculoPlacaMinusculaConInicialADiaDomingo_exitosoDebeDevolverPlacanoPermitidaExcepcion() {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 03, 11);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("awerty"), calendar);
            fail();
        } catch (PlacaNoPermitidaExcepcion e) {
            //Assert
            assertEquals(new PlacaNoPermitidaExcepcion().getMessage(), e.getMessage());
        }
    }

    @Test
    public void validarIngreso_validarIngresoVehiculoPlacaMinusculaConInicialADiaLunes_exitosoDebeDevolverPlacanoPermitidaExcepcion() {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 03, 12);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("awertyy"), calendar);
            fail();
        } catch (PlacaNoPermitidaExcepcion e) {
            //Assert
            assertEquals(new PlacaNoPermitidaExcepcion().getMessage(), e.getMessage());
        }
    }

    @Test
    public void validarIngreso_validarIngresoVehiculoPlacaMinusculaConInicialADiaMartes_exitosoNoDebeEntrarAlCatch() {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 03, 13);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("awerty"), calendar);
        } catch (Exception e) {
            fail();
        }
        //Assert
    }

    @Test
    public void validarIngreso_validarIngresoVehiculoPlacaMayusculaConInicialADiaViernes_exitosoNoDebeEntrarAlCatch() {
        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 03, 16);
        //Act
        try {
            ingresoParqueadero.validarIngreso(new Carro("AWERTY"), calendar);
        } catch (Exception e) {
            fail();
        }
        //Assert
    }
}
