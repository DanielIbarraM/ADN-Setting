package com.example.infraestructura.repositorio;

import android.content.Context;
import android.os.AsyncTask;

import com.example.dominio.modelo.entidad.Carro;
import com.example.dominio.modelo.entidad.Vehiculo;
import com.example.dominio.repositorio.VehiculoRepositorio;
import com.example.infraestructura.anticorrupcion.CarroTraductor;
import com.example.infraestructura.bd.CarroDao;
import com.example.infraestructura.entidadBd.CarroBd;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CarroRepositorioRoom  implements VehiculoRepositorio {

    private CarroDao carroDao;

    public CarroRepositorioRoom (Context contexto) {
        carroDao = AdministradorBaseDeDatos.obtenerInstancia(contexto).obtenerCarroDao();
    }

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        ConsultaListaCarrosAsincronica consultaListaCarros = new ConsultaListaCarrosAsincronica();
        try {
            listaVehiculos.addAll(CarroTraductor.mapearListaDeCarroDbACarroDominio(consultaListaCarros.execute().get()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaVehiculos;
    }

    @Override
    public void guardarVehiculo(Vehiculo vehiculo) {
        CarroBd carroBd;
        try {
            carroBd = CarroTraductor.mapearCarroDominioACarroDb((Carro) vehiculo);
        } catch (Exception e) {
            return;
        }
        CarroBd finalCarroBd = carroBd;
        AdministradorBaseDeDatos.EJECUTOR_SEGUNDO_PLANO.execute(() -> {
            carroDao.guardarCarro(finalCarroBd);
        });
    }

    @Override
    public void eliminarVehiculo(Vehiculo vehiculo) {
        CarroBd carroBd = null;
        try {
            carroBd = CarroTraductor.mapearCarroDominioACarroDb((Carro) vehiculo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        CarroBd finalCarroBd = carroBd;
        AdministradorBaseDeDatos.EJECUTOR_SEGUNDO_PLANO.execute(() -> {
            carroDao.eliminarCarro(finalCarroBd.obtenerPlaca());
        });
    }

    @Override
    public int obtenerCantidadVehiculos() {
        int cantidadCarros = 0;

        ConsultaCantidadCarrosAsincronico consultaCantidadCarrosAsincronico = new ConsultaCantidadCarrosAsincronico();
        try {
            cantidadCarros = consultaCantidadCarrosAsincronico.execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return cantidadCarros;
    }

    class ConsultaListaCarrosAsincronica extends AsyncTask<Void, Void, List<CarroBd>> {
        @Override
        protected List<CarroBd> doInBackground(Void... voids) {
            return carroDao.obtenerListaCarros();
        }
    }

    class ConsultaCantidadCarrosAsincronico extends AsyncTask<Void, Void, Integer> {
        @Override
        protected Integer doInBackground(Void... voids) {
            return carroDao.obtenerCantidadCarros();
        }
    }
}
