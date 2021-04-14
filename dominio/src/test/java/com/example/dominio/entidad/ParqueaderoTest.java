package com.example.dominio.entidad;

import org.junit.Test;
import static org.junit.Assert.*;

public class ParqueaderoTest {

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
