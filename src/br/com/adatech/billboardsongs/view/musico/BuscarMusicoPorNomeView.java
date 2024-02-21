package br.com.adatech.billboardsongs.view.musico;

import br.com.adatech.billboardsongs.modelo.Musico;
import br.com.adatech.billboardsongs.service.MusicoService;
import br.com.adatech.billboardsongs.view.component.TableView;

import java.util.Scanner;

public class BuscarMusicoPorNomeView {

    private MusicoService service;

    public BuscarMusicoPorNomeView(MusicoService service) {
        this.service = service;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome para consulta:");
        String nome = scanner.nextLine();
        Musico musico = service.pesquisarPorNome(nome);
        if (musico != null) {
            String[] headers = {"Nome"};
            String[][] lines = new String[1][1];
            lines[0][0] = musico.getNome();
            TableView view = new TableView();
            view.execute(headers, lines);
        } else {
            System.out.println("Nenhum músico foi encontrado com esse nome");
        }
    }

}
