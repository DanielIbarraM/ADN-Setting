package com.example.infraestructura.entidadBd;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabla_Vehiculo")
public abstract class VehiculoBd {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;
    @ColumnInfo(name = "placa")
    public String placa;
    @ColumnInfo(name = "fechaIngreso")
    public long fechaIngreso;
    @ColumnInfo(name = "fechaSalida")
    public long fechaSalida;

    public int getId() {
        return id;
    }
    
    public String obtenerPlaca() {
        return this.placa;
    }

    public void modificarPlaca(String placa) {
        this.placa = placa;
    }

    public long obtenerFechaIngreso() {
        return fechaIngreso;
    }

    public void modificarFechaIngreso(long fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public long obtenerFechaSalida() {
        return fechaSalida;
    }

    public void modificarFechaSalida(long fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
