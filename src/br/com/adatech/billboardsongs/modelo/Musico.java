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
    }

    public void adicionarMusica(Musica musica) {
        this.musicas.add(musica);
    }

    public List getMusicas() {
        return Collections.unmodifiableList(this.musicas);
    }

}
