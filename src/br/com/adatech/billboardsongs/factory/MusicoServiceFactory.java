package br.com.adatech.billboardsongs.factory;

import br.com.adatech.billboardsongs.infra.banco.BancoDeDados;
import br.com.adatech.billboardsongs.infra.repositorio.MusicoRepositorio;
import br.com.adatech.billboardsongs.service.MusicoService;

public class MusicoServiceFactory {

    public static MusicoService create() {
        BancoDeDados bancoDeDados = new BancoDeDados();
        MusicoRepositorio musicoRepositorio = new MusicoRepositorio(bancoDeDados);
        return new MusicoService(musicoRepositorio, null);
    }

}
