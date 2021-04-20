package com.example.infraestructura.bd;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.infraestructura.entidadBd.CarroBd;

import java.util.List;

@Dao
public interface CarroDao {

    @Insert
    void guardarCarro(CarroBd carroBd);

    @Query("SELECT * FROM tabla_carro")
    List<CarroBd> obtenerListaCarros();

    @Query("DELETE FROM tabla_carro WHERE placa = :placa")
    void eliminarCarro(String placa);

    @Query("SELECT COUNT(*) FROM tabla_carro")
    int obtenerCantidadCarros();

    @Query("SELECT * FROM tabla_carro WHERE placa = :placa")
    CarroBd obtenerCarro(String placa);

}
