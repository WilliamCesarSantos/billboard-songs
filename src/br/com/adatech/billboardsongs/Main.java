package br.com.adatech.billboardsongs;

import br.com.adatech.billboardsongs.factory.MusicoServiceFactory;
import br.com.adatech.billboardsongs.service.MusicoService;
import br.com.adatech.billboardsongs.view.MenuPrincipal;

public class Main {

    public static void main(String[] args) {
        MusicoService musicoService = MusicoServiceFactory.create();

        MenuPrincipal principal = new MenuPrincipal(musicoService);
        principal.execute();
    }

}