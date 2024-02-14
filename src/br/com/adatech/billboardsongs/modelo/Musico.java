package br.com.adatech.billboardsongs.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Musico extends Pessoa {

    private List musicas;
    private Boolean exclusivo;
    private List albuns;

    public Musico(String nome, Boolean exclusivo) {
        super(nome);
        this.exclusivo = exclusivo;
        this.musicas = new ArrayList();
        this.albuns = new ArrayList();
    }

    public Boolean getExclusivo() {
        return exclusivo;
    }

    public void setExclusivo(Boolean exclusivo) {
        this.exclusivo = exclusivo;
    }

    public void adicionarMusica(Musica musica) {
        this.musicas.add(musica);
    }

    public List getMusicas() {
        return Collections.unmodifiableList(this.musicas);
    }

    public void adicionarAlgum(Album album) {
        this.albuns.add(album);
    }

    public List getAlbuns() {
        return Collections.unmodifiableList(this.albuns);
    }

}
