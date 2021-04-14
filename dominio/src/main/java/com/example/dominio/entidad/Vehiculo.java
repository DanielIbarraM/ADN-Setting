package com.example.dominio.entidad;

import java.util.Calendar;

public abstract class Vehiculo {
    private String placa;
    private Calendar fechaIngreso;
    private Calendar fechaSalida;


    public String obtenerPlaca() {
        return placa;
    }

    public void modificarPlaca(String placa) {
        this.placa = placa;
    }

    public Calendar obtenerFechaIngreso() {
        return fechaIngreso;
    }

    public void modificarFechaIngreso(Calendar fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }


    public Calendar obtenerFechaSalida() {
        return fechaSalida;
    }

    public void modificarFechaSalida(Calendar fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
