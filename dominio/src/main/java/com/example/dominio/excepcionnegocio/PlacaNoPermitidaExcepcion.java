package com.example.dominio.excepcionnegocio;

public class PlacaNoPermitidaExcepcion extends RuntimeException {

    private static final String PLACA_NO_PERMITIDA = "No está autorizado a ingresar";

    public PlacaNoPermitidaExcepcion() {
        super(PLACA_NO_PERMITIDA);
    }
}
