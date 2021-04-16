package com.example.adn_danielibarra.mvp.modelo;

import android.content.Context;

import com.example.adn_danielibarra.mvp.modelo.contrato.RepositorioPrincipal;
import com.example.adn_danielibarra.mvp.presentador.contratos.PresentadorPrincipal;
import com.example.dominio.modelo.entidad.Moto;
import com.example.dominio.modelo.entidad.Vehiculo;
import com.example.dominio.repositorio.VehiculoRepositorio;
import com.example.dominio.servicio.ParqueaderoServicio;
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
    private ParqueaderoServicio parqueaderoServicio;
    private List<Vehiculo> vehiculoLista;

    public RepositorioPrincipalParqueadero (PresentadorPrincipal presentador, Context contexto) {
        this.presentador = presentador;
        this.contexto = contexto;
        this.vehiculoRepositorioCarro = new CarroRepositorioRoom(contexto);
        this.vehiculoRepositorioMoto = new MotoRepositorioRoom(contexto);
        parqueaderoServicio = new ParqueaderoServicio(vehiculoRepositorioCarro, vehiculoRepositorioMoto);
        vehiculoLista = new ArrayList<>();
    }

    @Override
    public void obtenerVehiculos() {
        vehiculoLista.clear();
        vehiculoLista.addAll(parqueaderoServicio.obtenerCarros());
        vehiculoLista.addAll(parqueaderoServicio.obtenerMotos());
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
            parqueaderoServicio.eliminarMoto(vehiculo);
        } else {
            parqueaderoServicio.eliminarCarro(vehiculo);
        }
    }

    @Override
    public int obtenerCantidadCarros() {
        return parqueaderoServicio.obtenerCantidadCarros();
    }

    @Override
    public int obtenerCantidadMotos() {
        return parqueaderoServicio.obtenerCantidadMotos();
    }

    @Override
    public void ingresarVehiculo(Vehiculo vehiculo) {
        if (vehiculo instanceof Moto) {
            parqueaderoServicio.guardarMoto(vehiculo);
        } else {
            parqueaderoServicio.guardarCarro(vehiculo);
        }
    }

    @Override
    public int calcularTotalVehiculo(Vehiculo vehiculo) {
        return parqueaderoServicio.calcularValorTotal(vehiculo);
    }
}
