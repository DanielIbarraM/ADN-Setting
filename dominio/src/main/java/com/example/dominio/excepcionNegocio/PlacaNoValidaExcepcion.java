package com.example.dominio.excepcionNegocio;

public class PlacaNoValidaExcepcion extends RuntimeException {

    private static final String PLACA_NO_VALIDA = "Placa no valida";

    public PlacaNoValidaExcepcion() {
        super(PLACA_NO_VALIDA);
    }
}
