package com.example.dominio.servicio.contrato;

import com.example.dominio.modelo.Vehiculo;

public interface ContratoParqueadero extends ContratoCarro, ContratoMoto {

    int calcularValorTotal(Vehiculo vehiculo);
}
