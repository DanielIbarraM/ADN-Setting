package com.example.dominio.modelo.entidad;

public class Carro extends Vehiculo {

    public Carro (String placa) {
        this.modificarPlaca(placa);
    }

    @Override
    public int compareTo(Object o) {
        Vehiculo vehiculo = (Vehiculo) o;
        return this.obtenerFechaIngreso().compareTo(vehiculo.obtenerFechaIngreso());
    }
}
