package com.example.dominio.servicio;

import com.example.dominio.modelo.entidad.Carro;
import com.example.dominio.modelo.entidad.Vehiculo;
import com.example.dominio.repositorio.VehiculoRepositorio;
import com.example.dominio.servicio.contrato.ContratoParqueadero;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

public class ParqueaderoServicioServicioDominioTest {

    ContratoParqueadero parqueaderoServicioDominio;
    VehiculoRepositorio carroRepositorioPersistencia;
    VehiculoRepositorio motoRepositorioPersistencia;

    @Before
    public void inicializar () {
        carroRepositorioPersistencia = Mockito.mock(VehiculoRepositorio.class);
        motoRepositorioPersistencia = Mockito.mock(VehiculoRepositorio.class);
        parqueaderoServicioDominio = new ParqueaderoServicio(carroRepositorioPersistencia, motoRepositorioPersistencia);
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

   


}
