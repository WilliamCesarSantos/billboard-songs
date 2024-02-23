package br.com.adatech.billboardsongs.view;

import br.com.adatech.billboardsongs.factory.ArtistaServiceFactory;
import br.com.adatech.billboardsongs.factory.MusicoServiceFactory;
import br.com.adatech.billboardsongs.view.artista.ArtistaView;
import br.com.adatech.billboardsongs.view.component.menu.AbstractMenuView;
import br.com.adatech.billboardsongs.view.component.menu.MenuItem;
import br.com.adatech.billboardsongs.view.musico.MusicoView;

public class MenuPrincipal extends AbstractMenuView {

    public MenuPrincipal() {
        super(new MenuItem[]{
                new MenuItem(1, "Album"),
                new MenuItem(2, "Artista"),
                new MenuItem(3, "Compositor"),
                new MenuItem(4, "Gravadora"),
                new MenuItem(5, "Musica"),
                new MenuItem(6, "Musico"),
                new MenuItem(0, "Sair")
        });
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 2 -> new ArtistaView(ArtistaServiceFactory.create(), MusicoServiceFactory.create()).execute();
            case 6 -> new MusicoView(MusicoServiceFactory.create()).execute();
            case 0 -> System.exit(1);
            default -> System.out.println("Opcao não disponível");
        }
        execute();
    }

}
