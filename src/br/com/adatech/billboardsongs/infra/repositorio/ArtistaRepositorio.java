package br.com.adatech.billboardsongs.infra.repositorio;

import br.com.adatech.billboardsongs.infra.banco.BancoDeDados;
import br.com.adatech.billboardsongs.modelo.Album;
import br.com.adatech.billboardsongs.modelo.Artista;
import br.com.adatech.billboardsongs.modelo.Musica;
import br.com.adatech.billboardsongs.modelo.Musico;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArtistaRepositorio extends AbstractRepositorio {

    public ArtistaRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }

    @Override
    protected Class classeModelo() {
        return Artista.class;
    }

    @Override
    public void gravar(Object objeto) {
        Album album = (Album) objeto;
        if (album.getId() == null) {
            album.setId(bancoDeDados.proximoId());
        }
        super.gravar(objeto);
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

    @Override
    protected Boolean filtraPorId(Object objeto, Long id) {
        Artista artista = (Artista) objeto;
        return Objects.equals(artista.getId(), id);
    }

}
