package com.example.dominio.modelo.paqueadero.CobrarParqueadero;

import com.example.dominio.excepcionnegocio.FechaSalidaErroneaExcepcion;
import com.example.dominio.modelo.Moto;
import com.example.dominio.modelo.parqueadero.Parqueadero;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CobrarServicioParqueaderoBaseMotoTest {

    Parqueadero parqueadero;
    Calendar calendar;
    Moto vehiculo;

    @Before
    public void inicializar () {
        parqueadero = new Parqueadero();
        calendar = Calendar.getInstance();
        vehiculo = new Moto("QWE012",0);
    }

    @Test
    public void calcularTotal_calcularTotalMotoConHoraFinalAnteriorAhoraDeSalidaConCilindrajeMenorAQuinientos_devuelveFechaSalidaErroneaExcepcion (){
        //Arrange
        vehiculo.modificarCilindraje(200);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*4;
        calendar.setTimeInMillis(calendar.getTimeInMillis()-tiempo);
        //Act
        try {
            parqueadero.calcularTotalVehiculo(vehiculo, calendar);
            fail();
        } catch (FechaSalidaErroneaExcepcion e) {
            //Assert
            assertEquals(new FechaSalidaErroneaExcepcion().getMessage(), e.getMessage());
        }
    }

    @Test
    public void calcularTotal_calcularTotalMotoConHoraFinalAnteriorAhoraDeSalidaConCilindrajeDeQuinientos_devuelveFechaSalidaErroneaExcepcion (){
        //Arrange
        vehiculo.modificarCilindraje(500);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*4;
        calendar.setTimeInMillis(calendar.getTimeInMillis()-tiempo);
        //Act
        try {
            parqueadero.calcularTotalVehiculo(vehiculo, calendar);
            fail();
        } catch (FechaSalidaErroneaExcepcion e) {
            //Assert
            assertEquals(new FechaSalidaErroneaExcepcion().getMessage(), e.getMessage());
        }
    }

    @Test
    public void calcularTotal_calcularTotalMotoConHoraFinalAnteriorAhoraDeSalidaConCilindrajeMayorAQuinientos_devuelveFechaSalidaErroneaExcepcion (){
        //Arrange
        vehiculo.modificarCilindraje(600);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*4;
        calendar.setTimeInMillis(calendar.getTimeInMillis()-tiempo);
        //Act
        try {
            parqueadero.calcularTotalVehiculo(vehiculo, calendar);
            fail();
        } catch (FechaSalidaErroneaExcepcion e) {
            //Assert
            assertEquals(new FechaSalidaErroneaExcepcion().getMessage(), e.getMessage());
        }
    }

    @Test
    public void calcularTotal_calcularTotalMotoConHoraSalidaYLlegadaIgualesConCilindrajeMenorAQuinientos_devuelveFechaSalidaErroneaExcepcion (){
        //Arrange
        vehiculo.modificarCilindraje(300);
        vehiculo.modificarFechaIngreso(calendar);
        //Act
        try {
            int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
            fail();
        } catch (FechaSalidaErroneaExcepcion e) {
            //Assert
            assertEquals(new FechaSalidaErroneaExcepcion().getMessage(), e.getMessage());
        }

        //Assert
    }

    @Test
    public void calcularTotal_calcularTotalMotoConCuatroHorasParqueadoConCilindrajeMayorAQuinientos_exitosoValoresIguales (){
        //Arrange
        vehiculo.modificarCilindraje(600);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*4;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(4000, valorTotal);
    }

    @Test
    public void calcularTotal_calcularTotalMotoConCuatroHorasParqueadoConCilindrajeMenorAQuinientos_exitosoValoresIguales(){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*4;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(2000, valorTotal);
    }

    @Test
    public void calcularTotal_calcularTotalMotoConOchoHorasParqueadoConCilindrajeMenorAQuinientos_exitosoValoresIguales (){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*8;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(4000, valorTotal);
    }

    @Test
    public void calcularTotal_calcularTotalMotoConOchoHorasParqueadoConCilindrajeMayorAQuinientos_exitosoValoresIguales (){
        //Arrange
        vehiculo.modificarCilindraje(700);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*8;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(6000, valorTotal);
    }

    @Test
    public void calcularTotal_calcularTotalMotoConVeinteHorasParqueadoCobroPorDiaConCilindrajeMenorAQuinientos_exitosoValoresIguales (){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*20;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(4000, valorTotal);
    }

    @Test
    public void calcularTotal_calcularTotalMotoConVeinteHorasParqueadoCobroPorDiaConCilindrajeMayorAQuinientos_exitosoValoresIguales (){
        //Arrange
        vehiculo.modificarCilindraje(800);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*20;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(6000, valorTotal);
    }

    @Test
    public void calcularTotal_calcularTotalMotoConVeinteSeisHorasParqueadoCobroPorDiaConCilindrajeMenorAQuinientos_exitosoValoresIguales (){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*26;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(5000, valorTotal);
    }

    @Test
    public void calcularTotal_calcularTotalMotoConVeinteSeisHorasParqueadoCobroPorDiaConCilindrajeMayorAQuinientos_exitosoValoresIguales (){
        //Arrange
        vehiculo.modificarCilindraje(700);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*26;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(7000, valorTotal);
    }

    @Test
    public void calcularTotal_calcularTotalMotoConSetentaYCincoHorasParqueadoCobroPorDiaConCilindrajeMenorAQuinientos_exitosoValoresIguales (){
        //Arrange
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*75;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(13500, valorTotal);
    }

    @Test
    public void calcularTotal_calcularTotalMotoConSetentaYCincoHorasParqueadoCobroPorDiaConCilindrajeMMayorAQuinientos_exitosoValoresIguales (){
        //Arrange
        vehiculo.modificarCilindraje(800);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*75;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+tiempo);
        //Act
        int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
        //Assert
        assertEquals(15500, valorTotal);
    }
}
