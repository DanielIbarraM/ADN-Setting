package com.example.infraestructura;

import android.content.Context;

import com.example.dominio.modelo.Carro;
import com.example.dominio.modelo.Vehiculo;
import com.example.dominio.repositorio.VehiculoRepositorio;

import java.util.ArrayList;
import java.util.List;

public class VehiculoRepositorioCarroTemporal implements VehiculoRepositorio {


    List<Vehiculo> vehiculoList = new ArrayList<>();

    public VehiculoRepositorioCarroTemporal(Context context) {
    }


    @Override
    public List<Vehiculo> obtenerVehiculos() {

        vehiculoList.add(new Carro("qwerty0"));
        vehiculoList.add(new Carro("qwerty1"));
        vehiculoList.add(new Carro("qwerty2"));
        vehiculoList.add(new Carro("qwerty3"));
        vehiculoList.add(new Carro("qwerty4"));

        return vehiculoList;
    }

    @Override
    public void guardarVehiculo(Vehiculo vehiculo) {
        System.out.println("Carro guardado");
    }

    @Override
    public void eliminarVehiculo(Vehiculo vehiculo) {
        System.out.println("Carro eliminado");
    }

    @Override
    public int obtenerCantidadVehiculos() {
        return vehiculoList.size();
    }
}
