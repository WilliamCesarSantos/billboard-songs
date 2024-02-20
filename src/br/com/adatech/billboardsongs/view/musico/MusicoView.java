package br.com.adatech.billboardsongs.view.musico;

import br.com.adatech.billboardsongs.service.MusicoService;
import com.sun.java.accessibility.util.SwingEventMonitor;

import java.util.Scanner;

public class MusicoView {

    private MusicoService service;

    public MusicoView(MusicoService service) {
        this.service = service;
    }

    public void execute() {
        System.out.println("Escolha uma opção");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Editar");
        System.out.println("4 - Excluir");
        System.out.println("0 - Voltar");

        Scanner scanner = new Scanner(System.in);
        Integer option = scanner.nextInt();
        executeOption(option);
    }

    protected void executeOption(Integer option) {
        if (option < 0 || option > 4) {
            System.out.println("Opcao invalida");
            execute();
        }
        switch (option) {
            case 1 -> new CadastrarMusicoView(this.service).execute();
//            2 -> new ListarMusicoView();
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
