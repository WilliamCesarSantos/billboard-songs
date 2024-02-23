package br.com.adatech.billboardsongs.view.artista;

import br.com.adatech.billboardsongs.modelo.Artista;
import br.com.adatech.billboardsongs.modelo.Musico;
import br.com.adatech.billboardsongs.service.ArtistaService;
import br.com.adatech.billboardsongs.service.MusicoService;
import br.com.adatech.billboardsongs.service.exception.ModeloInvalidoException;
import br.com.adatech.billboardsongs.service.exception.ServiceException;
import br.com.adatech.billboardsongs.view.ScannerSingleton;
import br.com.adatech.billboardsongs.view.component.select.SelectItemView;
import br.com.adatech.billboardsongs.view.component.select.SelectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadatrarArtistaView {

    private ArtistaService serivce;
    private MusicoService musicoService;

    public CadatrarArtistaView(ArtistaService serivce, MusicoService musicoService) {
        this.serivce = serivce;
        this.musicoService = musicoService;
    }

    public void execute() {
        Scanner scanner = ScannerSingleton.instance().getScanner();
        System.out.println("Informa o nome: ");
        String nome = scanner.nextLine();
        List musicos = musicos();
        System.out.println("Artista exclusivo(s/n): ");
        Boolean exclusivo = scanner.nextLine().equalsIgnoreCase("s");
        System.out.println("Informe o tipo do artista:");
        String tipo = scanner.nextLine();
        System.out.println("Informe o genero musical do artista: ");
        String genero = scanner.nextLine();
        Artista artista = new Artista(nome, musicos, exclusivo, tipo, genero);
        try {
            serivce.criar(artista);
        } catch (ModeloInvalidoException e) {
            System.err.println(e.getMessage());
            execute();
        } catch (ServiceException e) {
            System.err.println("Ocorreu um erro. Tenta novamente mais tarde.");
            execute();
        }
    }

    private List musicos() {
        System.out.println("Informe os musicos da formação:");
        Scanner scanner = ScannerSingleton.instance().getScanner();
        String continuar = "n";
        SelectItemView[] items = musicoItems();
        List musicos = new ArrayList();
        SelectView view = new SelectView("Codigo - Nome", items);
        do {
            view.execute();
            Object musico = view.selecionarItem();
            musicos.add(musico);
            System.out.println("Deseja incluir mais musicos(s/n)?");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        return musicos;
    }

    private SelectItemView[] musicoItems() {
        List musicos = musicoService.listar();
        SelectItemView[] items = new SelectItemView[musicos.size()];
        for (int index = 0; index < musicos.size(); index++) {
            Musico musico = (Musico) musicos.get(index);
            items[index] = new SelectItemView(musico.getId().toString(), musico.getNome(), musico);
        }
        return items;
    }
}
