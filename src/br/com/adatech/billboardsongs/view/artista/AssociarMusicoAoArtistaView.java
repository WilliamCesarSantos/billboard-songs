package br.com.adatech.billboardsongs.view.artista;

import br.com.adatech.billboardsongs.modelo.Artista;
import br.com.adatech.billboardsongs.modelo.Musico;
import br.com.adatech.billboardsongs.service.ArtistaService;
import br.com.adatech.billboardsongs.service.MusicoService;
import br.com.adatech.billboardsongs.service.exception.ServiceException;
import br.com.adatech.billboardsongs.view.component.select.SelectItemView;
import br.com.adatech.billboardsongs.view.component.select.SelectView;

import java.util.List;

public class AssociarMusicoAoArtistaView {

    private ArtistaService service;
    private MusicoService musicoService;

    public AssociarMusicoAoArtistaView(
            ArtistaService service,
            MusicoService musicoService
    ) {
        this.service = service;
        this.musicoService = musicoService;
    }

    public void execute() {
        System.out.println("Selecione o artista que deseja alterar:");
        SelectView selectArtista = new SelectView("Codigo - Nome", artistas());
        selectArtista.execute();
        Artista artista = (Artista) selectArtista.selecionarItem();

        System.out.println("Selecione o musico que deseja associar:");
        SelectView selectMusico = new SelectView("Codigo - Nome", musicos());
        selectMusico.execute();
        Musico musico = (Musico) selectMusico.selecionarItem();

        try {
            service.incluirMusico(artista.getId(), musico);
        } catch (ServiceException e) {
            System.err.println("Ocorreu um erro. Tente novamente mais tarde.");
            execute();
        }
    }

    private SelectItemView[] artistas() {
        List artistas = service.listar();
        SelectItemView[] items = new SelectItemView[artistas.size()];
        for (int index = 0; index < artistas.size(); index++) {
            Artista artista = (Artista) artistas.get(index);
            items[index] = new SelectItemView(
                    artista.getId().toString(),
                    artista.getNome(),
                    artista
            );
        }
        return items;
    }

    private SelectItemView[] musicos() {
        List musicos = musicoService.listar();
        SelectItemView[] items = new SelectItemView[musicos.size()];
        for (int index = 0; index < musicos.size(); index++) {
            Musico musico = (Musico) musicos.get(index);
            items[index] = new SelectItemView(
                    musico.getId().toString(),
                    musico.getNome(),
                    musico
            );
        }
        return items;
    }

}
