package br.com.adatech.billboardsongs.view.musico;

import br.com.adatech.billboardsongs.modelo.Musico;
import br.com.adatech.billboardsongs.service.MusicoService;
import br.com.adatech.billboardsongs.service.exception.ModeloInvalidoException;
import br.com.adatech.billboardsongs.service.exception.ServiceException;

import java.util.Scanner;

public class CadastrarMusicoView {

    private MusicoService service;

    public CadastrarMusicoView(MusicoService service) {
        this.service = service;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome: ");
        String nome = scanner.nextLine();
        System.out.println("Informe se o músico é exclusivo(s/n): ");
        String exclusivo = scanner.nextLine();
        Musico musico = new Musico(nome, exclusivo.equalsIgnoreCase("s"));
        try {
            service.criar(musico);
        } catch (ModeloInvalidoException exception) {
            System.err.println(exception.getMessage());
            execute();
        } catch (ServiceException e) {
            System.err.println("Ocorreu um erro. Tenta novamente mais tarde.");
            execute();
        }
    }

}
