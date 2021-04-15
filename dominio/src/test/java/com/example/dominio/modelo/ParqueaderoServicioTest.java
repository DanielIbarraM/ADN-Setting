package com.example.dominio.modelo;

import com.example.dominio.modelo.entidad.Parqueadero;

import org.junit.Test;
import static org.junit.Assert.*;

public class ParqueaderoServicioTest {

    @Test
    public void validarInstanciaNoNulo () {
        //Arrange
        Parqueadero parqueadero;
        //Act
        parqueadero = Parqueadero.obtenerUnicaInstancia();
        //Assert
        assertNotNull(parqueadero);
    }
}
