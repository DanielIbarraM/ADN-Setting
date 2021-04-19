package com.example.dominio.servicio;

import com.example.dominio.modelo.Vehiculo;
import com.example.dominio.modelo.parqueadero.Parqueadero;
import com.example.dominio.repositorio.VehiculoRepositorio;

public class ServicioSalidaParqueadero {

    VehiculoRepositorio carroRepositorio;
    VehiculoRepositorio motoRepositorio;
    Parqueadero parqueadero;

    public ServicioSalidaParqueadero(VehiculoRepositorio carroRepositorio, VehiculoRepositorio motoRepositorio, Parqueadero parqueadero) {
        this.carroRepositorio = carroRepositorio;
        this.motoRepositorio = motoRepositorio;
        this.parqueadero = parqueadero;
    }

    public void eliminarMoto (Vehiculo vehiculo) {
        carroRepositorio.eliminarVehiculo(vehiculo);
    }

    public void eliminarCarro (Vehiculo vehiculo){
        motoRepositorio.eliminarVehiculo(vehiculo);
    }
}
