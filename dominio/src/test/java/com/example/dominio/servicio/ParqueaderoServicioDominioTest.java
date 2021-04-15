package com.example.dominio.servicio;

import com.example.dominio.modelo.entidad.Carro;
import com.example.dominio.modelo.entidad.Moto;
import com.example.dominio.modelo.entidad.Vehiculo;
import com.example.dominio.repositorio.IVehiculoRepositorioPersistencia;
import com.example.dominio.servicio.interaceServicio.IParqueaderoServicioDominio;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ParqueaderoServicioDominioTest {

    IParqueaderoServicioDominio parqueaderoServicioDominio;
    IVehiculoRepositorioPersistencia carroRepositorioPersistencia;
    IVehiculoRepositorioPersistencia motoRepositorioPersistencia;

    @Before
    public void inicializar () {
        carroRepositorioPersistencia = Mockito.mock(IVehiculoRepositorioPersistencia.class);
        motoRepositorioPersistencia = Mockito.mock(IVehiculoRepositorioPersistencia.class);
        parqueaderoServicioDominio = new ParqueaderoServicioDominio(carroRepositorioPersistencia, motoRepositorioPersistencia);
    }

    @Test
    public void guardarCarroTeniedoDiezCarrosParqueados () {
        //Arrange
        Vehiculo vehiculo = new Carro("QWET-132");
        when(carroRepositorioPersistencia.obtenerCantidadVehiculos()).thenReturn(10);
        //Act
        try {
            parqueaderoServicioDominio.guardarCarro(vehiculo);
        } catch (Exception e) {
            fail();
        }
        //Assert
    }

    @Test
    public void guardarCarroTeniedoVeinteCarrosParqueados () {
        //Arrange
        Vehiculo vehiculo = new Carro("QWET-132");
        when(carroRepositorioPersistencia.obtenerCantidadVehiculos()).thenReturn(20);
        //Act
        try {
            parqueaderoServicioDominio.guardarCarro(vehiculo);
            fail();
        } catch (Exception e) {
        }
        //Assert
    }

    @Test
    public void guardarMotoTeniedoCincoMotosParqueados () {
        //Arrange
        Vehiculo vehiculo = new Moto("QWET-132", 200);
        when(motoRepositorioPersistencia.obtenerCantidadVehiculos()).thenReturn(5);
        //Act
        try {
            parqueaderoServicioDominio.guardarMoto(vehiculo);
        } catch (Exception e) {
            fail();
        }
        //Assert
    }

    @Test
    public void guardarMotoTeniedoDiezMotoParqueados () {
        //Arrange
        Vehiculo vehiculo = new Moto("QWET-132", 200);
        when(motoRepositorioPersistencia.obtenerCantidadVehiculos()).thenReturn(10);
        //Act
        try {
            parqueaderoServicioDominio.guardarMoto(vehiculo);
            fail();
        } catch (Exception e) {
        }
        //Assert
    }

    @Test
    public void guardarCarroConPlacaNula () {
        //Arrange
        Vehiculo vehiculo = new Carro(null);
        when(motoRepositorioPersistencia.obtenerCantidadVehiculos()).thenReturn(2);
        //Act
        try {
            parqueaderoServicioDominio.guardarMoto(vehiculo);
            fail();
        } catch (Exception e) {
        }
        //Assert
    }

    @Test
    public void guardarMotoConPlacaNula () {
        //Arrange
        Vehiculo vehiculo = new Moto(null, 200);
        when(motoRepositorioPersistencia.obtenerCantidadVehiculos()).thenReturn(2);
        //Act
        try {
            parqueaderoServicioDominio.guardarMoto(vehiculo);
            fail();
        } catch (Exception e) {
        }
        //Assert
    }

    @Test
    public void guardarCarroConPlacaVacia () {
        //Arrange
        Vehiculo vehiculo = new Carro("");
        when(motoRepositorioPersistencia.obtenerCantidadVehiculos()).thenReturn(2);
        //Act
        try {
            parqueaderoServicioDominio.guardarMoto(vehiculo);
            fail();
        } catch (Exception e) {
        }
        //Assert
    }

    @Test
    public void guardarMotoConPlacaVacia () {
        //Arrange
        Vehiculo vehiculo = new Moto("", 200);
        when(motoRepositorioPersistencia.obtenerCantidadVehiculos()).thenReturn(2);
        //Act
        try {
            parqueaderoServicioDominio.guardarMoto(vehiculo);
            fail();
        } catch (Exception e) {
        }
        //Assert
    }


}
