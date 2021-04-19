package com.example.adn_danielibarra;


import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.adn_danielibarra.mvp.vista.MainActivity;
import com.example.adn_danielibarra.pagina.DialogoIngresarVehiculoPagina;
import com.example.adn_danielibarra.pagina.MainActivityPagina;

import org.junit.Rule;
import org.junit.Test;

public class MainActivityPruebas {

    @Rule
    public ActivityScenarioRule<MainActivity> actividadPrincipal = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void guardarCarro_carroAgregadoEnVistaReciclada_verCarroEnPantalla() {
        //Arrange
        String placa = "AQWV456";
        //Act
        MainActivityPagina.clicBoton(MainActivityPagina.obtenerIdBotonIngresarVehiculo());
        DialogoIngresarVehiculoPagina.clicBoton(DialogoIngresarVehiculoPagina.obtenerRecursoTipoCarro());
        DialogoIngresarVehiculoPagina.editarCajaTexto(DialogoIngresarVehiculoPagina.obtenerRecursoCajaTextoPlaca(), placa);
        //Assert
        DialogoIngresarVehiculoPagina.clicBoton(DialogoIngresarVehiculoPagina.obtenerRecursoButonAgregarVehiculo());
    }

    @Test
    public void guardarMoto_motoAgregadoEnVistaReciclada_verMotoEnPantalla() {
        //Arrange
        String placa = "ZBTRYHE";
        String cilindraje = "200";
        //Act
        MainActivityPagina.clicBoton(MainActivityPagina.obtenerIdBotonIngresarVehiculo());
        DialogoIngresarVehiculoPagina.clicBoton(DialogoIngresarVehiculoPagina.obtenerRecursoTipoMoto());
        DialogoIngresarVehiculoPagina.editarCajaTexto(DialogoIngresarVehiculoPagina.obtenerRecursoCajaTextoPlaca(), placa);
        DialogoIngresarVehiculoPagina.editarCajaTexto(DialogoIngresarVehiculoPagina.obtenerRecursoCajaTextoCilindraje(), cilindraje);
        //Assert
        DialogoIngresarVehiculoPagina.clicBoton(DialogoIngresarVehiculoPagina.obtenerRecursoButonAgregarVehiculo());
    }
}
