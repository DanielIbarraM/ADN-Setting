package com.example.infraestructura.repositorio;

import android.content.Context;
import android.os.AsyncTask;

import com.example.dominio.modelo.Moto;
import com.example.dominio.modelo.Vehiculo;
import com.example.dominio.repositorio.VehiculoRepositorio;
import com.example.infraestructura.anticorrupcion.MotoTraductor;
import com.example.infraestructura.bd.MotoDao;
import com.example.infraestructura.entidadBd.MotoBd;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MotoRepositorioRoom implements VehiculoRepositorio {

    MotoDao motoDao;

    public MotoRepositorioRoom(Context contexto) {
        motoDao = AdministradorBaseDeDatos.obtenerInstancia(contexto).obtenerMotoDao();
    }

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        ConsultaListaMotoAsincronica consultaListaMotoAsincronica = new ConsultaListaMotoAsincronica();
        try {
            listaVehiculos.addAll(MotoTraductor.mapearListaDeMotosDbAMotoDominio(consultaListaMotoAsincronica.execute().get()));
        } catch (Exception e) {
        }

        return listaVehiculos;
    }

    @Override
    public void guardarVehiculo(Vehiculo vehiculo) {
        MotoBd motoBd = MotoTraductor.mapearDeMotoDominioAMotoDb((Moto) vehiculo);
        AdministradorBaseDeDatos.EJECUTOR_SEGUNDO_PLANO.execute(() -> {
            motoDao.guardarMoto(motoBd);
        });
    }

    @Override
    public void eliminarVehiculo(Vehiculo vehiculo) {
        MotoBd motoBd = MotoTraductor.mapearDeMotoDominioAMotoDb((Moto) vehiculo);
        AdministradorBaseDeDatos.EJECUTOR_SEGUNDO_PLANO.execute(() -> {
            motoDao.eliminarMoto(motoBd.obtenerPlaca());
        });
    }

    @Override
    public int obtenerCantidadVehiculos() {
        int cantidadMotos = 0;

        ObtenerCantidadMotoAsincronico obtenerCantidadMotoAsincronico = new ObtenerCantidadMotoAsincronico();
        try {
            cantidadMotos = obtenerCantidadMotoAsincronico.execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return cantidadMotos;
    }

    class ConsultaListaMotoAsincronica extends AsyncTask<Void, Void, List<MotoBd>> {
        @Override
        protected List<MotoBd> doInBackground(Void... voids) {
            return motoDao.obtenerListaMotos();
        }
    }

    class ObtenerCantidadMotoAsincronico extends AsyncTask<Void, Void, Integer> {
        @Override
        protected Integer doInBackground(Void... voids) {
            return motoDao.obtenerCantidadMotos();
        }
    }
}
