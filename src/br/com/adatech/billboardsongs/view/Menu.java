package br.com.adatech.billboardsongs.view;

import br.com.adatech.billboardsongs.service.MusicoService;
import br.com.adatech.billboardsongs.view.musico.MusicoView;

import java.util.Scanner;

public class Menu {

    private MusicoService musicoService;

    public Menu(MusicoService musicoService) {
        this.musicoService = musicoService;
    }

    public void execute() {
        System.out.println("Escolha uma opção");
        System.out.println("1 - Album");
        System.out.println("2 - Artista");
        System.out.println("3 - Compositor");
        System.out.println("4 - Gravadora");
        System.out.println("5 - Musica");
        System.out.println("6 - Musico");
        System.out.println("0 - Sair");

        Scanner scanner = new Scanner(System.in);
        Integer opcao = scanner.nextInt();
        executeOptions(opcao);
    }

    public void executeOptions(Integer option) {
        if (option < 0 || option > 6) {
            System.out.println("Opção invalida");
        }
        switch (option) {
            case 6 -> new MusicoView(musicoService).execute();
            case 0 -> System.exit(1);
            default -> System.out.println("Opcao não disponível");
        }
        execute();
    }
}
