package br.com.adatech.billboardsongs.view.musico;

import br.com.adatech.billboardsongs.service.MusicoService;
import br.com.adatech.billboardsongs.view.component.menu.AbstractMenuView;
import br.com.adatech.billboardsongs.view.component.menu.MenuItem;

import java.util.List;

public class MusicoView extends AbstractMenuView {

    private MusicoService service;

    public MusicoView(MusicoService service) {
        super(List.of(
                new MenuItem(1, "Cadastrar"),
                new MenuItem(2, "Listar"),
                new MenuItem(3, "Consultar por nome"),
                new MenuItem(4, "Editar"),
                new MenuItem(5, "Excluir"),
                new MenuItem(0, "Voltar")
        ));
        this.service = service;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1 -> new CadastrarMusicoView(this.service).execute();
            case 2 -> new ListarMusicoView(this.service).execute();
            case 3 -> new BuscarMusicoPorNomeView(this.service).execute();
//            3 -> new UpdateMusicoView();
//            4 -> new ExcluirMusicoView();
            case 0 -> {
                return;
            }
            default -> System.out.println("Opcao invalida");
        }
        execute();
    }
}
