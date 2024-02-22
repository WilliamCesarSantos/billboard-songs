package br.com.adatech.billboardsongs;

import br.com.adatech.billboardsongs.infra.banco.BancoDeDados;
import br.com.adatech.billboardsongs.infra.repositorio.MusicoRepositorio;
import br.com.adatech.billboardsongs.service.MusicoService;
import br.com.adatech.billboardsongs.view.Menu;
import br.com.adatech.billboardsongs.view.ScannerSingleton;

public class Main {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                ScannerSingleton.instance().getScanner().close();
            }
        });
        BancoDeDados bancoDeDados = new BancoDeDados();
        MusicoRepositorio musicoRepositorio = new MusicoRepositorio(bancoDeDados);
        MusicoService musicoService = new MusicoService(musicoRepositorio);

        Menu principal = new Menu(musicoService);
        principal.execute();
    }
}