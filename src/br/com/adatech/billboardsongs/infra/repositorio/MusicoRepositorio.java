package br.com.adatech.billboardsongs.infra.repositorio;

import br.com.adatech.billboardsongs.infra.banco.BancoDeDados;
import br.com.adatech.billboardsongs.infra.repositorio.exception.RepositorioException;
import br.com.adatech.billboardsongs.modelo.Musica;
import br.com.adatech.billboardsongs.modelo.Musico;

import java.util.List;
import java.util.Objects;

public class MusicoRepositorio extends AbstractRepositorio {

    public MusicoRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }

    @Override
    protected Class classeModelo() {
        return Musico.class;
    }

    @Override
    public void gravar(Object objeto) throws RepositorioException {
        Musico musico = (Musico) objeto;
        if (musico.getId() == null) {
            musico.setId(bancoDeDados.proximoId());
            throw new IllegalArgumentException("Falhou!!!");
        }
        super.gravar(objeto);
    }

    public List musicosQueGravaramAMusica(Musica musica) {
        return null;
    }

    public Musico buscarPorNome(String nome) {
        List musicos = listar();
        Musico musicosComONomeBuscado = null;
        for (Object objeto : musicos) {
            Musico musico = (Musico) objeto;
            if (musico.getNome().equalsIgnoreCase(nome)) {
                musicosComONomeBuscado = musico;
                break;
            }
        }
        return musicosComONomeBuscado;
    }

    @Override
    protected Boolean filtraPorId(Object objeto, Long id) {
        Musico musico = (Musico) objeto;
        return Objects.equals(musico.getId(), id);
    }
}
