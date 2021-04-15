package com.example.infraestructura.anticorrupcion;

import com.example.dominio.modelo.entidad.Moto;
import com.example.infraestructura.entidadBd.MotoBd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MotoTraductorTest {

    @Test
    public void mapearMotoDB_A_MotoDominioConObjetoNulo () {
        MotoBd motoBd = null;
        try {
            MotoTraductor.mapearMotoBdAMotoDominio(motoBd);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void mapearMotoDB_A_MotoDominioConFechasNulas () {
        MotoBd motoBd = new MotoBd();
        try {
            MotoTraductor.mapearMotoBdAMotoDominio(motoBd);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void mapearMotoDominio_A_MotoDBConObjetoNulo () {
        Moto moto = null;
        try {
            MotoTraductor.mapearDeMotoDominioAMotoDb(moto);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void mapearMotoDominio_A_MotoDbConFechasNulas () {
        Moto moto = new Moto("qwerty",450);
        try {
            MotoTraductor.mapearDeMotoDominioAMotoDb(moto);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void mapearListaDeMotoDbAMotoDominioconListaNula () {
        List<Moto> motoLista = null;

        try {
            MotoTraductor.mapearListaDeMotoDominioAMotoDb(motoLista);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void mapearListaDeMotoDbAMotoDominioconListaConUnObjetoNulo () {
        List<Moto> motoLista = motosDefecto();
        motoLista.add(null);

        try {
            MotoTraductor.mapearListaDeMotoDominioAMotoDb(motoLista);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void mapearListaDeMotoDbAMotoDominioconListaConUnObjetoNuloVerificarSIOmiteEseObjeto () {
        List<Moto> motoLista = motosDefecto();
        List<MotoBd> motoBdLista = new ArrayList<>();
        motoLista.add(null);
        motoLista.add(null);
        motoLista.add(null);

        try {
            motoBdLista.addAll(MotoTraductor.mapearListaDeMotoDominioAMotoDb(motoLista));
        } catch (Exception e) {
        }

        assertEquals(motoLista.size()-3, motoBdLista.size());
    }

    @Test
    public void mapearListaDeMotoDominioAMotoDBconListaNula () {
        List<MotoBd> motoDbLista = null;

        try {
            MotoTraductor.mapearListaDeMotosDbAMotoDominio(motoDbLista);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void mapearListaDeMotoDominioAMotoDbconListaConUnObjetoNulo () {
        List<Moto> motoLista = motosDefecto();
        List<MotoBd> motoBdLista = new ArrayList<>();
        motoLista.add(null);

        try {
            MotoTraductor.mapearListaDeMotoDominioAMotoDb(motoLista);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void mapearListaDeMotoDbAMotoDominioconListaConUnObjetoNuloVerificarSIOmiteEseObjetoz () {
        List<Moto> motoLista = new ArrayList<>();
        List<MotoBd> motoBdLista = motoBdDefecto();
        motoBdLista.add(null);
        motoBdLista.add(null);
        motoBdLista.add(null);

        try {
            motoLista.addAll(MotoTraductor.mapearListaDeMotosDbAMotoDominio(motoBdLista));
        } catch (Exception e) {
        }

        assertEquals(motoBdLista.size()-3, motoLista.size());
    }


















    private List<Moto> motosDefecto () {
        List<Moto> motoLista = new ArrayList<>();

        Moto moto1 = new Moto("QWERTY",400);
        Moto moto2 = new Moto("ZXCVB",650);
        Moto moto3 = new Moto("UHJKNKL",120);
        Moto moto4 = new Moto("SCVSVS",850);

        motoLista.add(moto1);
        motoLista.add(moto2);
        motoLista.add(moto3);
        motoLista.add(moto4);
        return motoLista;
    }

    private List<MotoBd> motoBdDefecto () {
        List<MotoBd> motoBdLista = new ArrayList<>();
        MotoBd motoBd1 = new MotoBd();
        MotoBd motoBd2 = new MotoBd();
        MotoBd motoBd3 = new MotoBd();
        MotoBd motoBd4 = new MotoBd();
        MotoBd motoBd5 = new MotoBd();
        motoBdLista.add(motoBd1);
        motoBdLista.add(motoBd2);
        motoBdLista.add(motoBd3);
        motoBdLista.add(motoBd4);
        motoBdLista.add(motoBd5);

        return motoBdLista;
    }
}
