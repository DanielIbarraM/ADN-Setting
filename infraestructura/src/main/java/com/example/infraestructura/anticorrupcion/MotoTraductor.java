package com.example.infraestructura.anticorrupcion;

import com.example.dominio.modelo.entidad.Moto;
import com.example.infraestructura.entidadBd.MotoBd;

import java.util.ArrayList;
import java.util.List;

public class MotoTraductor {

    public static Moto mapearMotoBdAMotoDominio (MotoBd motoBd) throws Exception{
        if (motoBd == null) throw new NullPointerException();
        Moto moto = new Moto(motoBd.obtenerPlaca(), motoBd.obtenerCilindraje());
        moto.modificarFechaIngreso(GeneralTraductor.mapearDeLongACalendar(motoBd.obtenerFechaIngreso()));
        moto.modificarFechaSalida(GeneralTraductor.mapearDeLongACalendar(motoBd.obtenerFechaSalida()));
        return moto;
    }

    public static MotoBd mapearDeMotoDominioAMotoDb (Moto moto) {
        if (moto == null) throw new NullPointerException();
        MotoBd motoBd = new MotoBd();
        motoBd.modificarPlaca(moto.obtenerPlaca());
        motoBd.modificarCilindraje(moto.obtenerCilindraje());
        motoBd.modificarFechaIngreso(GeneralTraductor.mapeaDeCalendarALong(moto.obtenerFechaIngreso()));
        motoBd.modificarFechaSalida(GeneralTraductor.mapeaDeCalendarALong(moto.obtenerFechaSalida()));
        return motoBd;
    }

    public static List<Moto> mapearListaDeMotosDbAMotoDominio (List<MotoBd> motoBdLista) throws Exception{
        if (motoBdLista == null) throw new NullPointerException();
        List<Moto> listaMoto = new ArrayList<>();
        for (MotoBd motoBd : motoBdLista) {
            try {
                listaMoto.add(mapearMotoBdAMotoDominio(motoBd));
            }catch (Exception e){}

        }
        return listaMoto;
    }

    public static List<MotoBd> mapearListaDeMotoDominioAMotoDb (List<Moto> carroDominioLista) throws Exception{
        if (carroDominioLista == null) throw new NullPointerException();
        List<MotoBd> listaMotoBd = new ArrayList<>();
        for (Moto carro: carroDominioLista) {
            try {
                listaMotoBd.add(mapearDeMotoDominioAMotoDb(carro));
            } catch (Exception e){}

        }
        return listaMotoBd;
    }
}
