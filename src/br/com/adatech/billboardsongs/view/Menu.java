package br.com.adatech.billboardsongs.view;

import br.com.adatech.billboardsongs.service.MusicoService;
import br.com.adatech.billboardsongs.view.musico.MusicoView;

public class Menu extends AbstractMenuView {

    private MusicoService musicoService;

    public Menu(MusicoService musicoService) {
        super(new String[]{
                "1 - Album",
                "2 - Artista",
                "3 - Compositor",
                "4 - Gravadora",
                "5 - Musica",
                "6 - Musico",
                "0 - Sair"
        });
        this.musicoService = musicoService;
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 6;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 6 -> new MusicoView(musicoService).execute();
            case 0 -> System.exit(1);
            default -> System.out.println("Opcao não disponível");
        }
        execute();
    }

}
