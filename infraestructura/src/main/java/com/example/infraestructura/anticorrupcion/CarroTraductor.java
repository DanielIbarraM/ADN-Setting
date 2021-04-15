package com.example.infraestructura.anticorrupcion;

import com.example.dominio.entidad.Carro;
import com.example.infraestructura.entidadBd.CarroBd;

import java.util.ArrayList;
import java.util.List;

public class CarroTraductor {

    public static Carro mapearCarroBdACarroDominio (CarroBd carroBd) throws Exception{
        if (carroBd==null) throw new NullPointerException();
        Carro carro = new Carro(carroBd.obtenerPlaca());
        carro.modificarFechaIngreso(GeneralTraductor.mapearDeLongACalendar(carroBd.obtenerFechaIngreso()));
        carro.modificarFechaSalida(GeneralTraductor.mapearDeLongACalendar(carroBd.obtenerFechaSalida()));
        return carro;
    }

    public static CarroBd mapearCarroDominioACarroDb (Carro carro) throws Exception{
        if (carro == null) throw new NullPointerException();
        CarroBd carroBd = new CarroBd();
        carroBd.modificarPlaca(carro.obtenerPlaca());
        carroBd.modificarFechaIngreso(GeneralTraductor.mapeaDeCalendarALong(carro.obtenerFechaIngreso()));
        carroBd.modificarFechaSalida(GeneralTraductor.mapeaDeCalendarALong(carro.obtenerFechaSalida()));
        return carroBd;
    }

    public static List<Carro> mapearListaDeCarroDbACarroDominio (List<CarroBd> carroBdLista) throws Exception{
        if (carroBdLista==null) throw new NullPointerException();
        List<Carro> listaCarro = new ArrayList<>();
        for (CarroBd carroBd: carroBdLista) {
            try {
                listaCarro.add(mapearCarroBdACarroDominio(carroBd));
            } catch (Exception e) {
            }
        }
        return listaCarro;
    }

    public static List<CarroBd> mapearListaDeCarroDominioACarroDb (List<Carro> carroDominioLista) throws Exception{
        if (carroDominioLista == null) throw new NullPointerException();
        List<CarroBd> listaCarroBd = new ArrayList<>();
        for (Carro carro: carroDominioLista) {
            try {
                listaCarroBd.add(mapearCarroDominioACarroDb(carro));
            } catch (Exception e) {
            }
        }
        return listaCarroBd;
    }
}
