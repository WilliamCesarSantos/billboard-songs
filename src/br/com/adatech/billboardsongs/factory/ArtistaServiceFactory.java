package br.com.adatech.billboardsongs.factory;

import br.com.adatech.billboardsongs.infra.banco.BancoDeDados;
import br.com.adatech.billboardsongs.infra.repositorio.ArtistaRepositorio;
import br.com.adatech.billboardsongs.service.ArtistaService;

public class ArtistaServiceFactory {

    public static ArtistaService create() {
        BancoDeDados bancoDeDados = new BancoDeDados();
        ArtistaRepositorio repositorio = new ArtistaRepositorio(bancoDeDados);
        return new ArtistaService(repositorio);
    }
}
