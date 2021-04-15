package com.example.infraestructura.repositorio;

import android.content.Context;

import androidx.room.Room;

import com.example.infraestructura.bd.CarroDao;
import com.example.infraestructura.bd.MotoDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdministradorBaseDeDatos {

    private CarroDao carroDao;
    private MotoDao motoDao;

    private static AdministradorBaseDeDatos administradorBaseDeDatos = null;

    private static final int NUMEROS_HILOS = 10;
    public static final ExecutorService EJECUTOR_SEGUNDO_PLANO = Executors.newFixedThreadPool(NUMEROS_HILOS);

    private AdministradorBaseDeDatos (Context contexto) {
        synchronized (AdministradorBaseDeDatos.class){
            Context contextoAplicacion = contexto.getApplicationContext();
            GeneralBaseDeDatosRoom baseDeDatosRoom = Room.databaseBuilder(contextoAplicacion, GeneralBaseDeDatosRoom.class, "BD-adn-ceiba")
                    .allowMainThreadQueries().build();
            carroDao = baseDeDatosRoom.obtenerCarroDao();
            motoDao = baseDeDatosRoom.obtenerMotoDao();
        }

    }

    public static AdministradorBaseDeDatos obtenerInstancia (Context contexto) {
        if (contexto == null) {
            throw new NullPointerException();
        }
        if (administradorBaseDeDatos==null){
            administradorBaseDeDatos = new AdministradorBaseDeDatos(contexto);
        }

        return administradorBaseDeDatos;
    }

    public CarroDao obtenerCarroDao() {
        return carroDao;
    }

    public MotoDao obtenerMotoDao() {
        return motoDao;
    }
}

