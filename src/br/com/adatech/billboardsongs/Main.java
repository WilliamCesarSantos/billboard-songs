package br.com.adatech.billboardsongs;

import br.com.adatech.billboardsongs.factory.MusicoServiceFactory;
import br.com.adatech.billboardsongs.service.MusicoService;
import br.com.adatech.billboardsongs.view.Menu;

public class Main {

    public static void main(String[] args) {
        MusicoService musicoService = MusicoServiceFactory.create();

        Menu principal = new Menu(musicoService);
        principal.execute();
    }

}