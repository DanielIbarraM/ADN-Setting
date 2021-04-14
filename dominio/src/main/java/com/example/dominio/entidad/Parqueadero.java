package com.example.dominio.entidad;

public class Parqueadero {

    private static Parqueadero parqueadero;

    private final int horaInicialDeCobroPorDia = 9;
    private final int horasDelDia = 24;
    private final int cantidadMaximaCarros = 20;
    private final int cantidadMaximaMotos = 10;

    private final String INICIAL_PLACA = "A";
    public final int LUNES = 2;
    public final int DOMINGO = 1;

    private final long HORA_EN_MILISEGUNDOS = 3600000;

    

    private Parqueadero() {
    }

    public static Parqueadero obtenerUnicaInstancia () {
        if (parqueadero!=null) return parqueadero;
        else return new Parqueadero();
    }

    public int obtenerhoraInicialDeCobroPorDia() {
        return horaInicialDeCobroPorDia;
    }

    public int obtenerhorasDelDia () {
        return horasDelDia;
    }

    public int obtenerCantidadMaximaCarros() {
        return cantidadMaximaCarros;
    }

    public int obtenerCantidadMaximaMotos() {
        return cantidadMaximaMotos;
    }


    public long obtenerHoraEnMilisegundos() {
        return HORA_EN_MILISEGUNDOS;
    }

    public String obtenerInicialPlaca() {
        return INICIAL_PLACA;
    }
}
