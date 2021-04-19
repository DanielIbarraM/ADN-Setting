package com.example.dominio.excepcionnegocio;

public class FechaSalidaErroneaExcepcion extends RuntimeException {

    private static final String FECHA_SALIDA_ANTERIOR_A_INGRESO = "La fecha de salida es anterior a la fecha de ingreso";

    public FechaSalidaErroneaExcepcion() {
        super(FECHA_SALIDA_ANTERIOR_A_INGRESO);
    }

}
