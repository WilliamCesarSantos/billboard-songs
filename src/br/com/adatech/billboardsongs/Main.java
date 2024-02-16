package br.com.adatech.billboardsongs;

import br.com.adatech.billboardsongs.infra.banco.BancoDeDados;
import br.com.adatech.billboardsongs.infra.repositorio.ArtistaRepositorio;
import br.com.adatech.billboardsongs.infra.repositorio.MusicoRepositorio;
import br.com.adatech.billboardsongs.modelo.Artista;
import br.com.adatech.billboardsongs.modelo.Musico;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArtistaRepositorio artistaRepositorio = new ArtistaRepositorio(new BancoDeDados());
        MusicoRepositorio musicoRepositorio = new MusicoRepositorio(new BancoDeDados());

        artistaRepositorio.gravar(new Artista("Will", List.of(), true, "The best", "The best"));
        musicoRepositorio.gravar(new Musico("Will", true));

        artistaRepositorio.listar();
        musicoRepositorio.listar();
    }

}
