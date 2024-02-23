package br.com.adatech.billboardsongs.view.component.select;

import br.com.adatech.billboardsongs.view.ScannerSingleton;

import java.util.List;
import java.util.Scanner;

public class SelectView {

    private String cabecalho;
    private List items;

    public SelectView(String cabecalho, List items) {
        this.cabecalho = cabecalho;
        this.items = items;
    }

    public void execute() {
        if (cabecalho != null) {
            System.out.println("| " + cabecalho + " |");
        }
        for (Object objeto : items) {
            SelectItemView item = (SelectItemView) objeto;
            System.out.println("| " + item.getCodigo() + " - " + item.getTexto() + " |");
        }
    }

    public Object selecionarItem() {
        SelectItemView itemSelecionado = null;
        System.out.println("Informe o código que deseja selecionar: ");
        Scanner scanner = ScannerSingleton.instance().getScanner();
        String codigo = scanner.nextLine();
        for (Object objeto : items) {
            SelectItemView item = (SelectItemView) objeto;
            if (item.getCodigo().equalsIgnoreCase(codigo)) {
                itemSelecionado = item;
            }
        }
        return itemSelecionado;
    }

}
