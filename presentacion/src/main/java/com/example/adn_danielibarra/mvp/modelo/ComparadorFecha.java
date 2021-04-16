package com.example.adn_danielibarra.mvp.modelo;

import com.example.dominio.modelo.entidad.Vehiculo;

import java.util.Comparator;

public class ComparadorFecha implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {

        Vehiculo vehiculo1 = (Vehiculo) o1;
        Vehiculo vehiculo2 = (Vehiculo) o2;
        return vehiculo2.obtenerFechaIngreso().compareTo(vehiculo1.obtenerFechaIngreso());
    }
}
