package br.com.adatech.billboardsongs.view.component.select;

import br.com.adatech.billboardsongs.view.ScannerSingleton;

import java.util.Scanner;

public class SelectView {

    private String cabecalho;
    private SelectItemView[] items;

    public SelectView(String cabecalho, SelectItemView[] items) {
        this.cabecalho = cabecalho;
        this.items = items;
    }

    public void execute() {
        if (cabecalho != null) {
            System.out.println("| " + cabecalho + " |");
        }
        for (SelectItemView item : items) {
            System.out.println("| " + item.getCodigo() + " - " + item.getTexto() + " |");
        }
    }

    public Object selecionarItem() {
        Object itemSelecionado = null;
        System.out.println("Informe o código que deseja selecionar: ");
        Scanner scanner = ScannerSingleton.instance().getScanner();
        String codigo = scanner.nextLine();
        for (SelectItemView item : items) {
            if (item.getCodigo().equalsIgnoreCase(codigo)) {
                itemSelecionado = item.getValor();
                break;
            }
        }
        return itemSelecionado;
    }

}
