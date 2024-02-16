package br.com.adatech.billboardsongs.infra.repositorio;

import br.com.adatech.billboardsongs.infra.banco.BancoDeDados;
import br.com.adatech.billboardsongs.modelo.Artista;
import br.com.adatech.billboardsongs.modelo.Musica;

import java.util.List;

public class ArtistaRepositorio extends AbstractRepositorio {

    public ArtistaRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }

    @Override
    protected Class classeModelo() {
        return Artista.class;
    }

    public List artistaQueGravaram(Musica musica) {
        return null;
    }

}
