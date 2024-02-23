package br.com.adatech.billboardsongs.view.artista;

import br.com.adatech.billboardsongs.service.ArtistaService;
import br.com.adatech.billboardsongs.service.MusicoService;

public class IncluirMusicoAoArtistaView {

    private ArtistaService service;
    private MusicoService musicoService;

    public IncluirMusicoAoArtistaView(ArtistaService service, MusicoService musicoService) {
        this.service = service;
        this.musicoService = musicoService;
    }

    public void execute() {

    }

}
