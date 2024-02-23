package br.com.adatech.billboardsongs.view.component.select;

public class SelectItemView {

    private String codigo;
    private String texto;
    private Object valor;

    public SelectItemView(String codigo, String texto, Object valor) {
        this.codigo = codigo;
        this.texto = texto;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTexto() {
        return texto;
    }

    public Object getValor() {
        return valor;
    }
}
