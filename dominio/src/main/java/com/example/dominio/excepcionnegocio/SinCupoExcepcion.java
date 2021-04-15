package com.example.dominio.excepcionnegocio;

public class SinCupoExcepcion extends RuntimeException {

    private static final String SIN_CUPO = "No hay cupo disponible";

    public SinCupoExcepcion() {
        super(SIN_CUPO);
    }
}