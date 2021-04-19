package com.example.infraestructura.repositorio;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.infraestructura.bd.CarroDao;
import com.example.infraestructura.bd.MotoDao;
import com.example.infraestructura.entidadBd.CarroBd;
import com.example.infraestructura.entidadBd.MotoBd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CarroBd.class, MotoBd.class}, version = 1)
public abstract class AdministradorBaseDeDatos extends RoomDatabase {

    public abstract CarroDao carroDao();
    public abstract MotoDao motoDao();

    private static AdministradorBaseDeDatos administradorBaseDeDatos = null;

    private static final int NUMEROS_HILOS = 10;
    public static final ExecutorService EJECUTOR_SEGUNDO_PLANO = Executors.newFixedThreadPool(NUMEROS_HILOS);

    public static AdministradorBaseDeDatos obtenerInstancia (Context contexto) {
        if (contexto == null) {
            throw new NullPointerException();
        }
        synchronized (AdministradorBaseDeDatos.class) {
            Context contextoAplicacion = contexto.getApplicationContext();
            if (administradorBaseDeDatos == null) {
                administradorBaseDeDatos = Room.databaseBuilder(contextoAplicacion, AdministradorBaseDeDatos.class, "BD-adn-ceiba")
                        .allowMainThreadQueries().build();
            }
        }

        return administradorBaseDeDatos;
    }
}

