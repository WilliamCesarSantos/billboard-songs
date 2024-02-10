package br.com.adatech.billboardsongs.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Compositor extends Pessoa{

    private List composicoes;
    private String generoMusical;

    public Compositor(String nome, String generoMusical) {
        super(nome);
        this.generoMusical = generoMusical;
        this.composicoes = new ArrayList();
    }

    public void adicionarComposicao(Musica musica) {
        this.composicoes.add(musica);
    }

    public List getComposicoes() {
        return Collections.unmodifiableList(this.composicoes);
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

}
