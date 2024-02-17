package br.com.adatech.billboardsongs.infra.repositorio;

import br.com.adatech.billboardsongs.infra.banco.BancoDeDados;
import br.com.adatech.billboardsongs.modelo.Album;
import br.com.adatech.billboardsongs.modelo.Artista;

import java.util.ArrayList;
import java.util.List;

public class AlbumRepositorio extends AbstractRepositorio {

    public AlbumRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }

    @Override
    protected Class classeModelo() {
        return Album.class;
    }

    public List consultarPorNome(String nome) {
        List albuns = listar();
        List albumComONomeBuscado = new ArrayList();
        for (Object objeto : albuns) {
            Album album = (Album) objeto;
            if (compararNomeAlbum(album, nome)) {
                albumComONomeBuscado.add(album);
            }
        }
        return albumComONomeBuscado;
    }

    public List consultarPorAutor(Artista autor) {
        List albuns = listar();
        List albunsDoAutor = new ArrayList();
        for (Object objeto : albuns) {
            Album album = (Album) objeto;
            if (compararAutor(album, autor)) {
                albunsDoAutor.add(album);
            }
        }
        return albunsDoAutor;
    }

    public List consultarPorAutorOuNome(Artista autor, String nomeDoAlbum) {
        List albuns = listar();
        List albunsFiltrado = new ArrayList();
        for (Object objeto : albuns) {
            Album album = (Album) objeto;
            if (compararNomeAlbum(album, nomeDoAlbum)
                    || compararAutor(album, autor)) {
                albunsFiltrado.add(album);
            }
        }
        return albunsFiltrado;
    }

    private Boolean compararAutor(Album album, Artista autor) {
        return autor != null
                && autor.getNome() != null
                && album.getAutor() != null
                && album.getAutor().getNome() != null
                && autor.getNome().equalsIgnoreCase(album.getAutor().getNome());
    }

    private Boolean compararNomeAlbum(Album album, String nomeParaComparacao) {
        return album.getNome() != null
                && nomeParaComparacao != null
                && album.getNome().contains(nomeParaComparacao);
        /*if (album.getNome() != null
                && nomeParaComparacao != null
                && album.getNome().contains(nomeParaComparacao)
        ) {
            return true;
        } else {
            return false;
        }*/
    }
}
