package br.com.adatech.billboardsongs.infra.repositorio;

import br.com.adatech.billboardsongs.infra.banco.BancoDeDados;
import br.com.adatech.billboardsongs.modelo.Artista;
import br.com.adatech.billboardsongs.modelo.Musica;

import java.util.ArrayList;
import java.util.List;

public class ArtistaRepositorio extends AbstractRepositorio {

    public ArtistaRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }

    @Override
    protected Class classeModelo() {
        return Artista.class;
    }

    public List artistaQueGravaram(Musica musica) {
        return null;
    }

    public List consultarArtistasPorGeneroMusica(String genero) {
        List artistas = listar();
        List artistasDoGenero = new ArrayList();
        for (Object objeto : artistas) {
            Artista artista = (Artista) objeto;
            if (genero.equalsIgnoreCase(artista.getGeneroMusical())) {
                artistasDoGenero.add(artista);
            }
        }
        return artistasDoGenero;
    }

}
