package com.example.dominio.excepcionNegocio;

public class FechaSalidaErronea extends RuntimeException {

    private static final String FECHA_SALIDA_ANTERIOR_A_INGRESO = "La fecha de salida es anterior a la fecha de ingreso";

    public FechaSalidaErronea() {
        super(FECHA_SALIDA_ANTERIOR_A_INGRESO);
    }

}
