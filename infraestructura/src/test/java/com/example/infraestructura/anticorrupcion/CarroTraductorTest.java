package com.example.infraestructura.anticorrupcion;

import com.example.dominio.modelo.entidad.Carro;
import com.example.infraestructura.entidadBd.CarroBd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CarroTraductorTest {

    @Test
    public void mapearCarroDB_A_CarroDominioConObjetoNulo () {
        CarroBd carroBd = null;
        try {
            CarroTraductor.mapearCarroBdACarroDominio(carroBd);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void mapearCarroDB_A_CarroDominioConFechasNulas () {
        CarroBd carroBd = new CarroBd();
        try {
            CarroTraductor.mapearCarroBdACarroDominio(carroBd);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void mapearCarroDominio_A_CarroDBConObjetoNulo () {
        Carro carro = null;
        try {
            CarroTraductor.mapearCarroDominioACarroDb(carro);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void mapearCarroDominio_A_CarroDbConFechasNulas () {
        Carro carro = new Carro("qwerty");
        try {
            CarroTraductor.mapearCarroDominioACarroDb(carro);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void mapearListaDeCarroDbACarroDominioconListaNula () {
        List<Carro> carroLista = null;

        try {
            CarroTraductor.mapearListaDeCarroDominioACarroDb(carroLista);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void mapearListaDeCarroDbACarroDominioconListaConUnObjetoNulo () {
        List<Carro> carroLista = carrosDefecto();
        carroLista.add(null);

        try {
            CarroTraductor.mapearListaDeCarroDominioACarroDb(carroLista);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void mapearListaDeCarroDbACarroDominioconListaConUnObjetoNuloVerificarSIOmiteEseObjeto () {
        List<Carro> carroLista = carrosDefecto();
        List<CarroBd> carroBdLista = new ArrayList<>();
        carroLista.add(null);
        carroLista.add(null);
        carroLista.add(null);

        try {
            carroBdLista.addAll(CarroTraductor.mapearListaDeCarroDominioACarroDb(carroLista));
        } catch (Exception e) {
        }

        assertEquals(carroLista.size()-3, carroBdLista.size());
    }

    @Test
    public void mapearListaDeCarroDominioACarroDBconListaNula () {
        List<CarroBd> carroDbLista = null;

        try {
            CarroTraductor.mapearListaDeCarroDbACarroDominio(carroDbLista);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void mapearListaDeCarroDominioACarroDbconListaConUnObjetoNulo () {
        List<Carro> carroLista = carrosDefecto();
        List<CarroBd> carroBdLista = new ArrayList<>();
        carroLista.add(null);

        try {
            CarroTraductor.mapearListaDeCarroDominioACarroDb(carroLista);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void mapearListaDeCarroDbACarroDominioconListaConUnObjetoNuloVerificarSIOmiteEseObjetoz () {
        List<Carro> carroLista = new ArrayList<>();
        List<CarroBd> carroBdLista = carroBdDefecto();
        carroBdLista.add(null);
        carroBdLista.add(null);
        carroBdLista.add(null);

        try {
            carroLista.addAll(CarroTraductor.mapearListaDeCarroDbACarroDominio(carroBdLista));
        } catch (Exception e) {
        }

        assertEquals(carroBdLista.size()-3, carroLista.size());
    }


















    private List<Carro> carrosDefecto () {
        List<Carro> carroLista = new ArrayList<>();

        Carro carro1 = new Carro("QWERTY");
        Carro carro2 = new Carro("ZXCVB");
        Carro carro3 = new Carro("UHJKNKL");
        Carro carro4 = new Carro("SCVSVS");

        carroLista.add(carro1);
        carroLista.add(carro2);
        carroLista.add(carro3);
        carroLista.add(carro4);
        return carroLista;
    }

    private List<CarroBd> carroBdDefecto () {
        List<CarroBd> carroBdLista = new ArrayList<>();
        CarroBd carroBd1 = new CarroBd();
        CarroBd carroBd2 = new CarroBd();
        CarroBd carroBd3 = new CarroBd();
        CarroBd carroBd4 = new CarroBd();
        CarroBd carroBd5 = new CarroBd();
        carroBdLista.add(carroBd1);
        carroBdLista.add(carroBd2);
        carroBdLista.add(carroBd3);
        carroBdLista.add(carroBd4);
        carroBdLista.add(carroBd5);

        return carroBdLista;
    }
}
