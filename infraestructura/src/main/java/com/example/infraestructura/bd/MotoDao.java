package com.example.infraestructura.bd;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.infraestructura.entidadBd.MotoBd;

import java.util.List;

@Dao
public interface MotoDao {

    @Insert
    void guardarMoto(MotoBd motoBd);

    @Query("SELECT * FROM tabla_moto")
    List<MotoBd> obtenerListaMotos();

    @Query("DELETE FROM tabla_moto WHERE placa = :placa")
    void eliminarMoto(String placa);

    @Query("SELECT COUNT(*) FROM tabla_carro")
    int obtenerCantidadMotos();

}
