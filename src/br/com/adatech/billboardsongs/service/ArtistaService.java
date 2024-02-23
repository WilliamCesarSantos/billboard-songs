package br.com.adatech.billboardsongs.service;

import br.com.adatech.billboardsongs.infra.repositorio.ArtistaRepositorio;
import br.com.adatech.billboardsongs.infra.repositorio.exception.RepositorioException;
import br.com.adatech.billboardsongs.modelo.Artista;
import br.com.adatech.billboardsongs.modelo.Musico;
import br.com.adatech.billboardsongs.service.exception.ModeloInvalidoException;
import br.com.adatech.billboardsongs.service.exception.ServiceException;

import java.util.List;

public class ArtistaService {

    private ArtistaRepositorio repositorio;

    public ArtistaService(ArtistaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criar(Artista artista) throws ServiceException {
        if (artista == null) {
            throw new ModeloInvalidoException("Artista informado não pode ser nulo");
        }
        if (artista.getNome() == null || artista.getNome().trim().isEmpty()) {
            throw new ModeloInvalidoException("Nome do artista não pode ser nulo");
        }
        if (!artista.getAtivo()) {
            throw new ModeloInvalidoException("Não é permitido cadastrar um artista inativo");
        }
        try {
            repositorio.gravar(artista);
        } catch (RepositorioException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    public void atualizar(Artista artista) throws ServiceException {
        if (artista == null) {
            throw new ModeloInvalidoException("Musico informado não pode ser nulo");
        }
        if (artista.getNome() == null) {
            throw new ModeloInvalidoException("Nome do músico não pode ser nulo");
        }
        Artista jaExistente = (Artista) repositorio.buscarPorId(artista.getId());
        if (jaExistente == null) {
            // Condicao valida que o músico exista na base.
            // Caso a condição seja atendida, significa que o músico não existe na base
            throw new ModeloInvalidoException("Musico não encontrado");
        }
        try {
            repositorio.gravar(artista);
        } catch (RepositorioException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    public void incluirMusico(Long idArtista, Musico musico) throws ServiceException {
        Artista artista = (Artista) repositorio.buscarPorId(idArtista);
        artista.adicionarMusico(musico);
        try {
            repositorio.gravar(artista);
        } catch (RepositorioException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    public List listar() {
        return repositorio.listar();
    }
}
