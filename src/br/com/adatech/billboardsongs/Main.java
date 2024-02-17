package br.com.adatech.billboardsongs;

import br.com.adatech.billboardsongs.infra.banco.BancoDeDados;
import br.com.adatech.billboardsongs.infra.repositorio.AlbumRepositorio;
import br.com.adatech.billboardsongs.infra.repositorio.ArtistaRepositorio;
import br.com.adatech.billboardsongs.infra.repositorio.MusicoRepositorio;
import br.com.adatech.billboardsongs.modelo.Album;
import br.com.adatech.billboardsongs.modelo.Artista;
import br.com.adatech.billboardsongs.modelo.Musico;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArtistaRepositorio artistaRepositorio = new ArtistaRepositorio(new BancoDeDados());
        MusicoRepositorio musicoRepositorio = new MusicoRepositorio(new BancoDeDados());
        AlbumRepositorio albumRepositorio = new AlbumRepositorio(new BancoDeDados());

        Artista willArt = new Artista("Will", List.of(), true, "The best", "The best");
        artistaRepositorio.gravar(willArt);
        musicoRepositorio.gravar(new Musico("Will", true));
        albumRepositorio.gravar(new Album("Never mind", willArt, LocalDate.now(), List.of(), null));

        artistaRepositorio.listar();
        musicoRepositorio.listar();
        albumRepositorio.consultarPorAutorOuNome(null, null);
    }

}
