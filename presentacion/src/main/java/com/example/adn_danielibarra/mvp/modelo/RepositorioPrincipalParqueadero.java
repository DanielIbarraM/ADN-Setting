package com.example.adn_danielibarra.mvp.modelo;

import android.content.Context;

import com.example.adn_danielibarra.mvp.modelo.contrato.RepositorioPrincipal;
import com.example.adn_danielibarra.mvp.presentador.contratos.PresentadorPrincipal;
import com.example.dominio.modelo.Moto;
import com.example.dominio.modelo.Vehiculo;
import com.example.dominio.repositorio.VehiculoRepositorio;
import com.example.dominio.servicio.ServicioParqueadero;
import com.example.infraestructura.repositorio.CarroRepositorioRoom;
import com.example.infraestructura.repositorio.MotoRepositorioRoom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioPrincipalParqueadero implements RepositorioPrincipal {

    private PresentadorPrincipal presentador;
    private Context contexto;
    private VehiculoRepositorio vehiculoRepositorioCarro;
    private VehiculoRepositorio vehiculoRepositorioMoto;
    private ServicioParqueadero servicioParqueadero;
    private List<Vehiculo> vehiculoLista;

    public RepositorioPrincipalParqueadero (PresentadorPrincipal presentador, Context contexto) {
        this.presentador = presentador;
        this.contexto = contexto;
        this.vehiculoRepositorioCarro = new CarroRepositorioRoom(contexto);
        this.vehiculoRepositorioMoto = new MotoRepositorioRoom(contexto);
        servicioParqueadero = new ServicioParqueadero(vehiculoRepositorioCarro, vehiculoRepositorioMoto);
        vehiculoLista = new ArrayList<>();
    }

    @Override
    public void obtenerVehiculos() {
        vehiculoLista.clear();
        vehiculoLista.addAll(servicioParqueadero.obtenerCarros());
        vehiculoLista.addAll(servicioParqueadero.obtenerMotos());
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
            servicioParqueadero.eliminarMoto(vehiculo);
        } else {
            servicioParqueadero.eliminarCarro(vehiculo);
        }
    }

    @Override
    public int obtenerCantidadCarros() {
        return servicioParqueadero.obtenerCantidadCarros();
    }

    @Override
    public int obtenerCantidadMotos() {
        return servicioParqueadero.obtenerCantidadMotos();
    }

    @Override
    public void ingresarVehiculo(Vehiculo vehiculo) {
        if (vehiculo instanceof Moto) {
            servicioParqueadero.guardarMoto(vehiculo);
        } else {
            servicioParqueadero.guardarCarro(vehiculo);
        }
    }

    @Override
    public int calcularTotalVehiculo(Vehiculo vehiculo) {
        return servicioParqueadero.calcularValorTotal(vehiculo);
    }
}
