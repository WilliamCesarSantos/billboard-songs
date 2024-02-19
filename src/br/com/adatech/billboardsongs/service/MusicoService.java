package br.com.adatech.billboardsongs.service;

import br.com.adatech.billboardsongs.infra.repositorio.MusicoRepositorio;
import br.com.adatech.billboardsongs.modelo.Musico;
import br.com.adatech.billboardsongs.service.exception.ModeloInvalidoException;

public class MusicoService {

    private MusicoRepositorio repositorio;

    public MusicoService(MusicoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criar(Musico musico) {
        if (musico == null) {
            throw new ModeloInvalidoException("Musico informado não pode ser nulo");
        }
        if (musico.getNome() == null) {
            throw new ModeloInvalidoException("Nome do músico não pode ser nulo");
        }
        repositorio.gravar(musico);
    }

    public void atualizar(Musico musico) {
        if (musico == null) {
            throw new ModeloInvalidoException("Musico informado não pode ser nulo");
        }
        if (musico.getNome() == null) {
            throw new ModeloInvalidoException("Nome do músico não pode ser nulo");
        }
        Musico jaExistente = repositorio.buscarPorNome(musico.getNome());
        if (jaExistente == null) {
            // Condicao valida que o músico exista na base.
            // Caso a condição seja atendida, significa que o músico não existe na base
            throw new ModeloInvalidoException("Musico não encontrado");
        }
        repositorio.gravar(musico);
    }

}
