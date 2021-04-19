package com.example.adn_danielibarra.mvp.modelo;

import android.content.Context;

import com.example.adn_danielibarra.mvp.modelo.contrato.RepositorioParqueadero;
import com.example.adn_danielibarra.mvp.presentador.contratos.PresentadorParqueadero;
import com.example.dominio.modelo.Moto;
import com.example.dominio.modelo.Vehiculo;
import com.example.dominio.repositorio.VehiculoRepositorio;
import com.example.dominio.servicio.ServicioParqueaderoBase;
import com.example.infraestructura.repositorio.CarroRepositorioRoom;
import com.example.infraestructura.repositorio.MotoRepositorioRoom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioParqueaderoImpl implements RepositorioParqueadero {

    private PresentadorParqueadero presentador;
    private VehiculoRepositorio vehiculoRepositorioCarro;
    private VehiculoRepositorio vehiculoRepositorioMoto;
    private ServicioParqueaderoBase servicioParqueaderoBase;
    private List<Vehiculo> vehiculoLista;

    public RepositorioParqueaderoImpl(PresentadorParqueadero presentador, Context contexto) {
        this.presentador = presentador;
        this.vehiculoRepositorioCarro = new CarroRepositorioRoom(contexto);
        this.vehiculoRepositorioMoto = new MotoRepositorioRoom(contexto);
        servicioParqueaderoBase = new ServicioParqueaderoBase(vehiculoRepositorioCarro, vehiculoRepositorioMoto);
        vehiculoLista = new ArrayList<>();
    }

    @Override
    public void obtenerVehiculos() {
        vehiculoLista.clear();
        vehiculoLista.addAll(servicioParqueaderoBase.obtenerCarros());
        vehiculoLista.addAll(servicioParqueaderoBase.obtenerMotos());
        ordenarListaPorFechaDescendente(vehiculoLista);
        presentador.mostrarVehiculos(vehiculoLista);
    }

    private void ordenarListaPorFechaDescendente (List<Vehiculo> vehiculoLista) {
        System.out.println("lista --- "+vehiculoLista);
        Collections.sort(vehiculoLista, new ComparadorFecha());
        System.out.println("lista --- "+vehiculoLista);
    }

    @Override
    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (vehiculo instanceof Moto) {
            servicioParqueaderoBase.eliminarMoto(vehiculo);
        } else {
            servicioParqueaderoBase.eliminarCarro(vehiculo);
        }
    }

    @Override
    public int obtenerCantidadCarros() {
        return servicioParqueaderoBase.obtenerCantidadCarros();
    }

    @Override
    public int obtenerCantidadMotos() {
        return servicioParqueaderoBase.obtenerCantidadMotos();
    }

    @Override
    public void ingresarVehiculo(Vehiculo vehiculo) {
        if (vehiculo instanceof Moto) {
            servicioParqueaderoBase.guardarMoto(vehiculo);
        } else {
            servicioParqueaderoBase.guardarCarro(vehiculo);
        }
    }

    @Override
    public int calcularTotalVehiculo(Vehiculo vehiculo) {
        return servicioParqueaderoBase.calcularValorTotal(vehiculo);
    }
}
