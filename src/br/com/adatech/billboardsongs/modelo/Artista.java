package br.com.adatech.billboardsongs.modelo;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Artista {

    private Long id;
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
        this.ativo = true;
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

    public Boolean removerMusico(Musico musico) {
        return this.musicos.remove(musico);
    }

    public Musico removerMusico(Long idMusico) {
        Musico musicoRemovido = null;
        Iterator iterator = musicos.iterator();
        while(iterator.hasNext()) {
            Musico musicoDaLista = (Musico) iterator.next();
            if (Objects.equals(musicoDaLista.getId(), idMusico)) {
                musicoRemovido = musicoDaLista;
                iterator.remove();
            }
        }
        return musicoRemovido;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
