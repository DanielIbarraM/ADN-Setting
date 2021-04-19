package com.example.dominio.servicio;

import com.example.dominio.excepcionnegocio.PlacaNoValidaExcepcion;
import com.example.dominio.excepcionnegocio.SinCupoExcepcion;
import com.example.dominio.modelo.Carro;
import com.example.dominio.modelo.Moto;
import com.example.dominio.modelo.Vehiculo;
import com.example.dominio.repositorio.VehiculoRepositorio;
import com.example.dominio.servicio.contrato.ContratoParqueadero;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

public class ServicioServicioParqueaderoBaseDominioTest {

    ContratoParqueadero parqueaderoServicioDominio;
    VehiculoRepositorio carroRepositorioPersistencia;
    VehiculoRepositorio motoRepositorioPersistencia;

    @Before
    public void inicializar () {
        carroRepositorioPersistencia = Mockito.mock(VehiculoRepositorio.class);
        motoRepositorioPersistencia = Mockito.mock(VehiculoRepositorio.class);
        parqueaderoServicioDominio = new ServicioParqueaderoBase(carroRepositorioPersistencia, motoRepositorioPersistencia);
    }

    @Test
    public void guardarCarro_guardarCarroTeniedoDiezCarrosParqueados_exitosoNodebeEntrarEnELCatch () {
        //Arrange
        Vehiculo vehiculo = new Carro("QWET-132");
        when(carroRepositorioPersistencia.obtenerCantidadVehiculos()).thenReturn(10);
        //Act
        try {
            parqueaderoServicioDominio.guardarCarro(vehiculo);
        } catch (Exception e) {
            //Assert
            fail();
        }
    }

    @Test
    public void guardarCarro_guardarCarroTeniedoVeinteCarrosParqueados_devuelveSinCupoExcepcion () {
        //Arrange
        Vehiculo vehiculo = new Carro("QWET-132");
        when(carroRepositorioPersistencia.obtenerCantidadVehiculos()).thenReturn(20);
        //Act
        try {
            parqueaderoServicioDominio.guardarCarro(vehiculo);
            fail();
        } catch (SinCupoExcepcion e) {
            //Assert
            assertEquals(new SinCupoExcepcion().getMessage(), e.getMessage());
        }

    }

    @Test
    public void guardarMoto_guardarMotoTeniedoCincoMotosParqueados_exitosoNodebeEntrarEnELCatch () {
        //Arrange
        Vehiculo vehiculo = new Moto("QWET-132", 200);
        when(motoRepositorioPersistencia.obtenerCantidadVehiculos()).thenReturn(5);
        //Act
        try {
            parqueaderoServicioDominio.guardarMoto(vehiculo);
        } catch (Exception e) {
            //Assert
            fail();
        }
    }

    @Test
    public void guardarMoto_guardarMotoTeniedoDiezMotoParqueados_devuelveSinCupoExcepcion () {
        //Arrange
        Vehiculo vehiculo = new Moto("QWET-132", 200);
        when(motoRepositorioPersistencia.obtenerCantidadVehiculos()).thenReturn(10);
        //Act
        try {
            parqueaderoServicioDominio.guardarMoto(vehiculo);
            fail();
        } catch (SinCupoExcepcion e) {
            //Assert
            assertEquals(new SinCupoExcepcion().getMessage(), e.getMessage());
        }
    }

    @Test
    public void guardarCarro_guardarCarroConPlacaNula_devuelvePlacaNoValidaExcepcion () {
        //Arrange
        Vehiculo vehiculo = new Carro(null);
        when(motoRepositorioPersistencia.obtenerCantidadVehiculos()).thenReturn(2);
        //Act
        try {
            parqueaderoServicioDominio.guardarMoto(vehiculo);
            fail();
        } catch (PlacaNoValidaExcepcion e) {
            //Assert
            assertEquals(new PlacaNoValidaExcepcion().getMessage(), e.getMessage());
        }
    }

    @Test
    public void guardarMoto_guardarMotoConPlacaNula_devuelvePlacaNoValidaExcepcion () {
        //Arrange
        Vehiculo vehiculo = new Moto(null, 200);
        when(motoRepositorioPersistencia.obtenerCantidadVehiculos()).thenReturn(2);
        //Act
        try {
            parqueaderoServicioDominio.guardarMoto(vehiculo);
            fail();
        } catch (PlacaNoValidaExcepcion e) {
            //Assert
            assertEquals(new PlacaNoValidaExcepcion().getMessage(), e.getMessage());
        }
    }

    @Test
    public void guardarCarro_guardarCarroConPlacaVacia_devuelvePlacaNoValidaExcepcion () {
        //Arrange
        Vehiculo vehiculo = new Carro("");
        when(motoRepositorioPersistencia.obtenerCantidadVehiculos()).thenReturn(2);
        //Act
        try {
            parqueaderoServicioDominio.guardarMoto(vehiculo);
            fail();
        } catch (PlacaNoValidaExcepcion e) {
            //Assert
            assertEquals(new PlacaNoValidaExcepcion().getMessage(), e.getMessage());
        }
    }

    @Test
    public void guardarMoto_guardarMotoConPlacaVacia_devuelvePlacaNoValidaExcepcion () {
        //Arrange
        Vehiculo vehiculo = new Moto("", 200);
        when(motoRepositorioPersistencia.obtenerCantidadVehiculos()).thenReturn(2);
        //Act
        try {
            parqueaderoServicioDominio.guardarMoto(vehiculo);
            fail();
        } catch (PlacaNoValidaExcepcion e) {
            //Assert
            assertEquals(new PlacaNoValidaExcepcion().getMessage(), e.getMessage());
        }
    }


}
