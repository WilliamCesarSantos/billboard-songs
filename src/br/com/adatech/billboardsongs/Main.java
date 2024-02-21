package br.com.adatech.billboardsongs;

import br.com.adatech.billboardsongs.infra.banco.BancoDeDados;
import br.com.adatech.billboardsongs.infra.repositorio.MusicoRepositorio;
import br.com.adatech.billboardsongs.service.MusicoService;
import br.com.adatech.billboardsongs.view.Menu;

public class Main {

    public static void main(String[] args) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        MusicoRepositorio musicoRepositorio = new MusicoRepositorio(bancoDeDados);
        MusicoService musicoService = new MusicoService(musicoRepositorio);

        Menu principal = new Menu(musicoService);
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.err.println("Exceção não tratada: " + e.getMessage());
                main(args);
            }
        });
        principal.execute();
    }
}