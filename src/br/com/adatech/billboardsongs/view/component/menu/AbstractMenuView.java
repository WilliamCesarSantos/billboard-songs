package br.com.adatech.billboardsongs.view.component.menu;

import br.com.adatech.billboardsongs.view.ScannerSingleton;

import java.util.List;

public abstract class AbstractMenuView {

    private MenuItem[] items;

    public AbstractMenuView(MenuItem[] items) {
        this.items = items;
    }

    public void execute() {
        for (MenuItem item : items) {
            System.out.println(item.getCodigo() + " - " + item.getTexto());
        }
        System.out.println("Escolha uma opção:");
        String option = ScannerSingleton.instance().getScanner().nextLine();
        executeOption(option);
    }

    private void executeOption(String option) {
        MenuItem item = selectItem(option);
        if (item == null) {
            System.out.println("Opção invalida");
            execute();
        } else {
            executeOption(item.getCodigo());
        }
    }

    private MenuItem selectItem(String option) {
        MenuItem item = null;
        for (Object objeto : items) {
            MenuItem currentItem = (MenuItem) objeto;
            if (currentItem.getCodigo().toString().equalsIgnoreCase(option)) {
                item = currentItem;
                break;
            }
        }
        return item;
    }


    protected abstract void executeOption(Integer option);

}
