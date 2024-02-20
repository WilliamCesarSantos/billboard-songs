package br.com.adatech.billboardsongs.view.musico;

import br.com.adatech.billboardsongs.service.MusicoService;
import br.com.adatech.billboardsongs.view.AbstractMenuView;

public class MusicoView extends AbstractMenuView {

    private MusicoService service;

    public MusicoView(MusicoService service) {
        super(new String[]{
                "1 - Cadastrar",
                "2 - Listar",
                "3 - Editar",
                "4 - Excluir",
                "0 - Voltar"
        });
        this.service = service;
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 4;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1 -> new CadastrarMusicoView(this.service).execute();
            case 2 -> new ListarMusicoView(this.service).execute();
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
