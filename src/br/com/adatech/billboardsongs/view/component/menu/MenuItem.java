package br.com.adatech.billboardsongs.view.component.menu;

public class MenuItem {

    private final Integer codigo;
    private final String texto;

    public MenuItem(Integer codigo, String texto) {
        this.codigo = codigo;
        this.texto = texto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getTexto() {
        return texto;
    }
}
