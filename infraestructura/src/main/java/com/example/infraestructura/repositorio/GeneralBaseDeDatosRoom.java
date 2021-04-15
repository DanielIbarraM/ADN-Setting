package com.example.infraestructura.repositorio;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.infraestructura.bd.CarroDao;
import com.example.infraestructura.bd.MotoDao;
import com.example.infraestructura.entidadBd.CarroBd;
import com.example.infraestructura.entidadBd.MotoBd;

@Database(entities = {CarroBd.class, MotoBd.class}, version = 1)
public abstract class GeneralBaseDeDatosRoom extends RoomDatabase {

    public abstract CarroDao obtenerCarroDao();
    public abstract MotoDao obtenerMotoDao();
}
