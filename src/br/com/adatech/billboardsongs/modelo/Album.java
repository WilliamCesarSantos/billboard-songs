package br.com.adatech.billboardsongs.modelo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Album {

    private Long id;
    private final String nome;
    private final Artista autor;
    private final LocalDate dataLancamento;
    private final List musicas;
    private final List participacoes;

    public Album(String nome, Artista autor, LocalDate dataLancamento, List musicas, List participacoes) {
        this.nome = nome;
        this.autor = autor;
        this.dataLancamento = dataLancamento;
        this.musicas = musicas;
        this.participacoes = participacoes;
    }

    public String getNome() {
        return nome;
    }

    public Artista getAutor() {
        return autor;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public List getMusicas() {
        return Collections.unmodifiableList(musicas);
    }

    public List getParticipacoes() {
        return Collections.unmodifiableList(participacoes);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
