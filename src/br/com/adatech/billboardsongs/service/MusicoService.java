package br.com.adatech.billboardsongs.service;

import br.com.adatech.billboardsongs.infra.repositorio.MusicoRepositorio;
import br.com.adatech.billboardsongs.modelo.Musico;
import br.com.adatech.billboardsongs.service.exception.ModeloInvalidoException;

import java.util.List;

public class MusicoService {

    private MusicoRepositorio repositorio;

    public MusicoService(MusicoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criar(Musico musico) {
        if (musico == null) {
            throw new ModeloInvalidoException("Musico informado não pode ser nulo");
        }
        if (musico.getNome() == null || musico.getNome().trim().isEmpty()) {
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
        Musico jaExistente = (Musico) repositorio.buscarPorId(musico.getId());
        if (jaExistente == null) {
            // Condicao valida que o músico exista na base.
            // Caso a condição seja atendida, significa que o músico não existe na base
            throw new ModeloInvalidoException("Musico não encontrado");
        }
        repositorio.gravar(musico);
    }

    public void excluir(Musico musico) {
        if (musico == null) {
            throw new ModeloInvalidoException("Musico informado não pode ser nulo");
        }
        if (musico.getId() == null) {
            throw new ModeloInvalidoException("Musico deve ter id para exclusão");
        }
        Musico jaExistente = (Musico) repositorio.buscarPorId(musico.getId());
        if (jaExistente == null) {
            throw new ModeloInvalidoException("Musico não encontrado");
        }
        repositorio.excluir(jaExistente);
    }

    public void excluir(Long id) {
        if (id == null) {
            throw new ModeloInvalidoException("Id não pode ser nulo");
        }
        Musico jaExistente = (Musico) repositorio.buscarPorId(id);
        if (jaExistente == null) {
            throw new ModeloInvalidoException("Musico não encontrado");
        }
        repositorio.excluir(jaExistente);
    }

    public List listar() {
        return repositorio.listar();
    }

}
