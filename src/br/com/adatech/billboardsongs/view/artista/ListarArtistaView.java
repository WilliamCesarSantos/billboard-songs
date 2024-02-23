package br.com.adatech.billboardsongs.view.artista;

import br.com.adatech.billboardsongs.modelo.Artista;
import br.com.adatech.billboardsongs.modelo.Musico;
import br.com.adatech.billboardsongs.service.ArtistaService;
import br.com.adatech.billboardsongs.view.component.table.TableView;

import java.util.List;

public class ListarArtistaView {

    private ArtistaService service;

    public ListarArtistaView(ArtistaService service) {
        this.service = service;
    }

    public void execute() {
        String[] headers = {"Codigo", "Nome", "Musicos", "Exclusivo", "Ativo", "Tipo", "Genero musical"};
        List artistas = service.listar();
        String[][] lines = new String[artistas.size()][headers.length];
        for (int index = 0; index < artistas.size(); index++) {
            Artista artista = (Artista) artistas.get(index);
            lines[index][0] = artista.getId().toString();
            lines[index][1] = artista.getNome();
            lines[index][2] = musicos(artista.getMusicos());
            lines[index][3] = artista.getExclusivo() ? "Sim" : "Não";
            lines[index][4] = artista.getAtivo() ? "Sim" : "Não";
            lines[index][5] = artista.getTipo();
            lines[index][6] = artista.getGeneroMusical();
        }
        TableView view = new TableView();
        view.execute(headers, lines);
    }

    private String musicos(List musicos) {
        String nomes = "";
        for (Object objeto : musicos) {
            Musico musico = (Musico) objeto;
            nomes = nomes + musico + ", ";
        }
        return nomes;
    }

}
