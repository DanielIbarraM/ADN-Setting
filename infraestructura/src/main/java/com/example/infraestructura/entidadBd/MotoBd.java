package com.example.infraestructura.entidadBd;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "tabla_moto")
public class MotoBd extends VehiculoBd {

    @ColumnInfo(name = "cilindraje")
    public int cilindraje;

    public int obtenerCilindraje() {
        return cilindraje;
    }

    public void modificarCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}
