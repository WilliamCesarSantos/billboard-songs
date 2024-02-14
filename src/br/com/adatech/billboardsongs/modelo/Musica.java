package br.com.adatech.billboardsongs.modelo;

import java.util.Collections;
import java.util.List;

public class Musica {

    private final String nome;
    private final List compositores;
    private final String letra;
    private final Float duracao;

    public Musica(String nome, List compositores, String letra, Float duracao) {
        this.nome = nome;
        this.compositores = compositores;
        this.letra = letra;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public List getCompositores() {
        return Collections.unmodifiableList(this.compositores);
    }

    public String getLetra() {
        return letra;
    }

    public Float getDuracao() {
        return duracao;
    }
}
