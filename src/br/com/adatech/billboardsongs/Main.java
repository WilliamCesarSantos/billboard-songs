package br.com.adatech.billboardsongs;

import br.com.adatech.billboardsongs.service.MusicoService;
import br.com.adatech.billboardsongs.service.exception.ModeloInvalidoException;
import br.com.adatech.billboardsongs.infra.banco.BancoDeDados;
import br.com.adatech.billboardsongs.infra.repositorio.MusicoRepositorio;
import br.com.adatech.billboardsongs.modelo.Musico;

public class Main {

    public static void main(String[] args) {
        MusicoRepositorio musicoRepositorio = new MusicoRepositorio(new BancoDeDados());
        MusicoService controller = new MusicoService(musicoRepositorio);
        execute(controller, new Musico(null, true));
        musicoRepositorio.listar();
    }

    public static void execute(MusicoService controller, Musico musico) {
        try {
            controller.criar(musico);
            System.out.println("Musico gravado com sucesso!");
        } catch (ModeloInvalidoException exception) {
            exception.printStackTrace();
            musico.setNome("Will");
            execute(controller, musico);
        }
    }

}
