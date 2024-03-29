package br.com.adatech.billboardsongs.view.artista;

import br.com.adatech.billboardsongs.service.ArtistaService;
import br.com.adatech.billboardsongs.service.MusicoService;
import br.com.adatech.billboardsongs.view.component.menu.AbstractMenuView;
import br.com.adatech.billboardsongs.view.component.menu.MenuItem;

public class ArtistaView extends AbstractMenuView {

    private ArtistaService service;
    private MusicoService musicoService;

    public ArtistaView(ArtistaService service, MusicoService musicoService) {
        super(new MenuItem[]{
                new MenuItem(1, "Cadastrar"),
                new MenuItem(2, "Listar"),
                new MenuItem(3, "Associar musicos"),
                new MenuItem(0, "Voltar")
        });
        this.service = service;
        this.musicoService = musicoService;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1 -> new CadatrarArtistaView(this.service, this.musicoService).execute();
            case 2 -> new ListarArtistaView(this.service).execute();
            case 3 -> new AssociarMusicoAoArtistaView(this.service, this.musicoService).execute();
            case 0 -> {
                return;
            }
            default -> System.out.println("Opção invalida");
        }
        execute();
    }
}
