package br.com.adatech.billboardsongs.modelo;

import java.util.Collections;
import java.util.List;

public class Artista {

    private String nome;
    private List musicos;
    private List albuns;
    private Boolean exclusivo;
    private Boolean ativo;
    private String tipo;
    private String generoMusical;

    public Artista(String nome, List musicos, Boolean exclusivo, String tipo, String generoMusical) {
        this.nome = nome;
        this.musicos = musicos;
        this.exclusivo = exclusivo;
        this.tipo = tipo;
        this.generoMusical = generoMusical;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List getMusicos() {
        return Collections.unmodifiableList(musicos);
    }

    public void adicionarMusico(Musico musico) {
        this.musicos.add(musico);
    }

    public void removerMusico(Musico musico) {
        this.musicos.remove(musico);
    }

    public List getAlbuns() {
        return Collections.unmodifiableList(albuns);
    }

    public void adicionarAlbum(Album album) {
        this.albuns.add(album);
    }

    public Boolean getExclusivo() {
        return exclusivo;
    }

    public void setExclusivo(Boolean exclusivo) {
        this.exclusivo = exclusivo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }
}
