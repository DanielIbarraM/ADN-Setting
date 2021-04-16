package com.example.dominio.modelo.entidad;

public class Moto extends Vehiculo {

    private int cilindraje;

    public Moto(String placa, int cilindraje) {
        this.modificarPlaca(placa);
        this.modificarCilindraje(cilindraje);
    }

    public int obtenerCilindraje() {
        return cilindraje;
    }

    public void modificarCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    @Override
    public int compareTo(Object o) {
        Vehiculo vehiculo = (Vehiculo) o;
        return this.obtenerFechaIngreso().compareTo(vehiculo.obtenerFechaIngreso());
    }
}
