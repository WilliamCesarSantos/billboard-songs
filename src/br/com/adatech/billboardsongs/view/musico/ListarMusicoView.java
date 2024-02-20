package br.com.adatech.billboardsongs.view.musico;

import br.com.adatech.billboardsongs.modelo.Musico;
import br.com.adatech.billboardsongs.service.MusicoService;

import java.util.List;

public class ListarMusicoView {

    private MusicoService service;

    public ListarMusicoView(MusicoService service) {
        this.service = service;
    }

    public void execute() {
        System.out.println("| Codigo  |  Nome     | Exclusivo   | ");
        List musicos = service.listar();
        for (Object objeto : musicos) {
            Musico musico = (Musico) objeto;
            System.out.print("| ");
            System.out.print(musico.getId());
            System.out.print(" | ");
            System.out.print(musico.getNome());
            System.out.print(" | ");
            System.out.print(musico.getExclusivo() ? "Sim" : "Não");
            System.out.println(" |");
        }
    }
}
