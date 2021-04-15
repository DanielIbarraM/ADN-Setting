package com.example.dominio.servicio.CobrarParqueadero;

import com.example.dominio.modelo.entidad.Moto;
import com.example.dominio.modelo.entidad.Parqueadero;
import com.example.dominio.modelo.agregado.cobrarparqueaderoservicio.CobrarParqueaderoMoto;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class CobrarParqueaderoMotoTest {

    Parqueadero parqueadero;
    CobrarParqueaderoMoto cobrarParqueaderoMoto;
    Calendar calendar;
    Moto vehiculo;

    @Before
    public void inicializar () {
        parqueadero = Parqueadero.obtenerUnicaInstancia();
        cobrarParqueaderoMoto = new CobrarParqueaderoMoto(parqueadero);
        calendar = Calendar.getInstance();
        vehiculo = new Moto("QWE012",0);
    }

    @Test
    public void calcularTotalMotoConHoraFinalAnteriorAhoraDeSalidaConCilindrajeMenorAQuinientos (){
        //Arrange
        vehiculo.modificarCilindraje(200);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*4;
        calendar.setTimeInMillis(calendar.getTimeInMillis()-tiempo);
        //Act
        int valorTotal = cobrarParqueaderoMoto.calcularTotal(vehiculo, calendar);
        //Assert
        assertEquals(500, valorTotal);
    }

    @Test
    public void calcularTotalMotoConHoraFinalAnteriorAhoraDeSalidaConCilindrajeDeQuinientos (){
        //Arrange
        vehiculo.modificarCilindraje(500);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*4;
        calendar.setTimeInMillis(calendar.getTimeInMillis()-tiempo);
        //Act
        int valorTotal = cobrarParqueaderoMoto.calcularTotal(vehiculo, calendar);
        //Assert
        assertEquals(500, valorTotal);
    }

    @Test
    public void calcularTotalMotoConHoraFinalAnteriorAhoraDeSalidaConCilindrajeMayorAQuinientos (){
        //Arrange
        vehiculo.modificarCilindraje(600);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*4;
        calendar.setTimeInMillis(calendar.getTimeInMillis()-tiempo);
        //Act
        int valorTotal = cobrarParqueaderoMoto.calcularTotal(vehiculo, calendar);
        //Assert
        assertEquals(2500, valorTotal);
    }

    @Test
    public void calcularTotalMotoConHoraSalidaYLlegadaIgualesConCilindrajeMenorAQuinientos  (){
        //Arrange
        vehiculo.modificarCilindraje(300);
        vehiculo.modificarFechaIngreso(calendar);
        //Act
        int valorTotal = cobrarParqueaderoMoto.calcularTotal(vehiculo, calendar);
        //Assert
        assertEquals(500, valorTotal);
    }

    @Test
    public void calcularTotalMotoConCuatroHorasParqueadoConCilindrajeMayorAQuinientos (){
        //Arrange
        vehiculo.modificarCilindraje(600);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*4;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = cobrarParqueaderoMoto.calcularTotal(vehiculo, calendar);
        //Assert
        assertEquals(4000, valorTotal);
    }

    @Test
    public void calcularTotalMotoConCuatroHorasParqueadoConCilindrajeMenorAQuinientos(){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*4;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = cobrarParqueaderoMoto.calcularTotal(vehiculo, calendar);
        //Assert
        assertEquals(2000, valorTotal);
    }

    @Test
    public void calcularTotalMotoConOchoHorasParqueadoConCilindrajeMenorAQuinientos (){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*8;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = cobrarParqueaderoMoto.calcularTotal(vehiculo, calendar);
        //Assert
        assertEquals(4000, valorTotal);
    }

    @Test
    public void calcularTotalMotoConOchoHorasParqueadoConCilindrajeMayorAQuinientos (){
        //Arrange
        vehiculo.modificarCilindraje(700);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*8;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = cobrarParqueaderoMoto.calcularTotal(vehiculo, calendar);
        //Assert
        assertEquals(6000, valorTotal);
    }

    @Test
    public void calcularTotalMotoConVeinteHorasParqueadoCobroPorDiaConCilindrajeMenorAQuinientos (){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*20;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = cobrarParqueaderoMoto.calcularTotal(vehiculo, calendar);
        //Assert
        assertEquals(4000, valorTotal);
    }

    @Test
    public void calcularTotalMotoConVeinteHorasParqueadoCobroPorDiaConCilindrajeMayorAQuinientos (){
        //Arrange
        vehiculo.modificarCilindraje(800);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*20;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = cobrarParqueaderoMoto.calcularTotal(vehiculo, calendar);
        //Assert
        assertEquals(6000, valorTotal);
    }

    @Test
    public void calcularTotalMotoConVeinteSeisHorasParqueadoCobroPorDiaConCilindrajeMenorAQuinientos (){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*26;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = cobrarParqueaderoMoto.calcularTotal(vehiculo, calendar);
        //Assert
        assertEquals(5000, valorTotal);
    }

    @Test
    public void calcularTotalMotoConVeinteSeisHorasParqueadoCobroPorDiaConCilindrajeMayorAQuinientos (){
        //Arrange
        vehiculo.modificarCilindraje(700);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*26;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = cobrarParqueaderoMoto.calcularTotal(vehiculo, calendar);
        //Assert
        assertEquals(7000, valorTotal);
    }

    @Test
    public void calcularTotalMotoConSetentaYCincoHorasParqueadoCobroPorDiaConCilindrajeMenorAQuinientos (){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*75;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = cobrarParqueaderoMoto.calcularTotal(vehiculo, calendar);
        //Assert
        assertEquals(13500, valorTotal);
    }

    @Test
    public void calcularTotalMotoConSetentaYCincoHorasParqueadoCobroPorDiaConCilindrajeMMayorAQuinientos (){
        //Arrange
        vehiculo.modificarCilindraje(800);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*75;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = cobrarParqueaderoMoto.calcularTotal(vehiculo, calendar);
        //Assert
        assertEquals(15500, valorTotal);
    }
}
