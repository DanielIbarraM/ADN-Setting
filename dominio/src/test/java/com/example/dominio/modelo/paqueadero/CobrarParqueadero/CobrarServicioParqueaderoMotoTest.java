package com.example.dominio.modelo.paqueadero.CobrarParqueadero;

import com.example.dominio.excepcionnegocio.FechaSalidaErronea;
import com.example.dominio.modelo.Moto;
import com.example.dominio.modelo.parqueadero.Parqueadero;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CobrarServicioParqueaderoMotoTest {

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
    public void calcularTotalMotoConHoraFinalAnteriorAhoraDeSalidaConCilindrajeMenorAQuinientos (){
        //Arrange
        vehiculo.modificarCilindraje(200);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*4;
        calendar.setTimeInMillis(calendar.getTimeInMillis()-tiempo);
        //Act
        try {
            int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
            fail();
        } catch (FechaSalidaErronea e) {
            assertEquals(FechaSalidaErronea.class.getName(), e.getClass().getName());
        }
    }

    @Test
    public void calcularTotalMotoConHoraFinalAnteriorAhoraDeSalidaConCilindrajeDeQuinientos (){
        //Arrange
        vehiculo.modificarCilindraje(500);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*4;
        calendar.setTimeInMillis(calendar.getTimeInMillis()-tiempo);
        //Act
        try {
            parqueadero.calcularTotalVehiculo(vehiculo, calendar);
            fail();
        } catch (FechaSalidaErronea e) {
            assertEquals(FechaSalidaErronea.class.getName(), e.getClass().getName());
        }
        //Assert
    }

    @Test
    public void calcularTotalMotoConHoraFinalAnteriorAhoraDeSalidaConCilindrajeMayorAQuinientos (){
        //Arrange
        vehiculo.modificarCilindraje(600);
        vehiculo.modificarFechaIngreso(Calendar.getInstance());
        long tiempo = parqueadero.obtenerHoraEnMilisegundos()*4;
        calendar.setTimeInMillis(calendar.getTimeInMillis()-tiempo);
        //Act
        try {
            parqueadero.calcularTotalVehiculo(vehiculo, calendar);
            fail();
        } catch (FechaSalidaErronea e) {
            assertEquals(FechaSalidaErronea.class.getName(), e.getClass().getName());
        }
        //Assert
    }

    @Test
    public void calcularTotalMotoConHoraSalidaYLlegadaIgualesConCilindrajeMenorAQuinientos  (){
        //Arrange
        vehiculo.modificarCilindraje(300);
        vehiculo.modificarFechaIngreso(calendar);
        //Act
        try {
            int valorTotal = parqueadero.calcularTotalVehiculo(vehiculo, calendar);
            fail();
        } catch (FechaSalidaErronea e) {
            assertEquals(FechaSalidaErronea.class.getName(), e.getClass().getName());
        }

        //Assert
    }

    @Test
    public void calcularTotalMotoConCuatroHorasParqueadoConCilindrajeMayorAQuinientos (){
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
    public void calcularTotalMotoConCuatroHorasParqueadoConCilindrajeMenorAQuinientos(){
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
    public void calcularTotalMotoConOchoHorasParqueadoConCilindrajeMenorAQuinientos (){
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
    public void calcularTotalMotoConOchoHorasParqueadoConCilindrajeMayorAQuinientos (){
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
    public void calcularTotalMotoConVeinteHorasParqueadoCobroPorDiaConCilindrajeMenorAQuinientos (){
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
    public void calcularTotalMotoConVeinteHorasParqueadoCobroPorDiaConCilindrajeMayorAQuinientos (){
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
    public void calcularTotalMotoConVeinteSeisHorasParqueadoCobroPorDiaConCilindrajeMenorAQuinientos (){
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
    public void calcularTotalMotoConVeinteSeisHorasParqueadoCobroPorDiaConCilindrajeMayorAQuinientos (){
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
    public void calcularTotalMotoConSetentaYCincoHorasParqueadoCobroPorDiaConCilindrajeMenorAQuinientos (){
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
    public void calcularTotalMotoConSetentaYCincoHorasParqueadoCobroPorDiaConCilindrajeMMayorAQuinientos (){
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
