package com.example.dominio.modelo;

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

}
