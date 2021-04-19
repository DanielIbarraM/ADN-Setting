package com.example.infraestructura.anticorrupcion;

import com.example.dominio.modelo.Carro;
import com.example.infraestructura.entidadBd.CarroBd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CarroTraductorTest {

    @Test
    public void mapearCarroBdACarroDominio_convertirUnaListadeConUnValorNulo_exitosoDebePasarPorFail () {
        //Arrange
        CarroBd carroBd = null;
        try {
            //Act
            CarroTraductor.mapearCarroBdACarroDominio(carroBd);
            //Assert
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void mapearCarroBdACarroDominio_mapearCarroDBACarroDominioConFechasNulas_exitosoNoDebeEntrarAlCatch () {
        //Arrange
        CarroBd carroBd = new CarroBd();
        try {
            //Act
            CarroTraductor.mapearCarroBdACarroDominio(carroBd);
        } catch (Exception e) {
            fail();
        }
        //Assert
    }

    @Test
    public void mapearCarroDominioACarroDb_mapearCarroDominioACarroDBConObjetoNulo_debeEntrarAlCatch () {
        //Arrange
        Carro carro = null;
        try {
            //Act
            CarroTraductor.mapearCarroDominioACarroDb(carro);
            //Assert
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void mapearCarroDominioACarroDb_mapearCarroDominioACarroDbConFechasNulas_exitosoNoDebeEntrarAlCatch () {
        Carro carro = new Carro("qwerty");
        try {
            CarroTraductor.mapearCarroDominioACarroDb(carro);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void mapearListaDeCarroDominioACarroDb_mapearListaDeCarroDbACarroDominioconListaNula_exitosoDebeEntrarAlCatch () {
        List<Carro> carroLista = null;

        try {
            CarroTraductor.mapearListaDeCarroDominioACarroDb(carroLista);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void mapearListaDeCarroDominioACarroDb_mapearListaDeCarroDbACarroDominioconListaConUnObjetoNulo_exitosoNoDebeEntrarAlCatch () {
        List<Carro> carroLista = carrosDefecto();
        carroLista.add(null);

        try {
            CarroTraductor.mapearListaDeCarroDominioACarroDb(carroLista);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void mapearListaDeCarroDominioACarroDb_mapearListaDeCarroDbACarroDominioconListaConUnObjetoNuloVerificarSIOmiteEseObjeto_TamañodeListaIgualAlEsperado () {
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
    public void mapearListaDeCarroDbACarroDominio_mapearListaDeCarroDominioACarroDBconListaNulaExitosoDebeEntrarAlCatch () {
        List<CarroBd> carroDbLista = null;

        try {
            CarroTraductor.mapearListaDeCarroDbACarroDominio(carroDbLista);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void mapearListaDeCarroDominioACarroDb_mapearListaDeCarroDominioACarroDbconListaConUnObjetoNulo_exitosoNoDebeEntrarAlCatch () {
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
    public void mapearListaDeCarroDbACarroDominiomapearListaDeCarroDbACarroDominioconListaConUnObjetoNuloVerificarSIOmiteEseObjetos_tamañoListaIgualAlEsperado () {
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
