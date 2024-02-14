package br.com.adatech.billboardsongs.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gravadora {

    private String nome;
    private List artistas;
    private List albuns;

    public Gravadora(String nome) {
        this.nome = nome;
        this.artistas = new ArrayList();
        this.albuns = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List getArtistas() {
        return Collections.unmodifiableList(artistas);
    }

    public void adicionarArtista(Artista artista) {
        this.artistas.add(artista);
    }

    public List getAlbuns() {
        return Collections.unmodifiableList(albuns);
    }

    public void adicionarAlbum(Album album) {
        this.albuns.add(album);
    }

}
