package br.com.adatech.billboardsongs.view.musico;

import br.com.adatech.billboardsongs.modelo.Musico;
import br.com.adatech.billboardsongs.service.MusicoService;
import br.com.adatech.billboardsongs.view.component.table.TableView;

import java.util.List;

public class ListarMusicoView {

    private MusicoService service;

    public ListarMusicoView(MusicoService service) {
        this.service = service;
    }

    public void execute() {
        String[] headers = {"Codigo", "Nome", "Exclusivo"};
        List musicos = service.listar();
        String[][] lines = new String[musicos.size()][headers.length];
        for (int index = 0; index < musicos.size(); index++) {
            Musico musico = (Musico) musicos.get(index);
            lines[index][0] = musico.getId().toString();
            lines[index][1] = musico.getNome();
            lines[index][2] = musico.getExclusivo() ? "Sim" : "Não";
        }
        TableView view = new TableView();
        view.execute(headers, lines);
    }
}
