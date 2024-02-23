package br.com.adatech.billboardsongs.view.component.menu;

import br.com.adatech.billboardsongs.view.ScannerSingleton;

import java.util.List;

public abstract class AbstractMenuView {

    private List items;

    public AbstractMenuView(List items) {
        this.items = items;
    }

    public void execute() {
        System.out.println("Escolha uma opção:");
        for (Object objeto : items) {
            MenuItem item = (MenuItem) objeto;
            System.out.println(item.getCodigo() + " - " + item.getTexto());
        }
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
