package br.com.adatech.billboardsongs.view;

public abstract class AbstractMenuView {

    private String[] options;

    public AbstractMenuView(String[] options) {
        this.options = options;
    }

    public void execute() {
        System.out.println("Escolha uma opção:");
        for (String option : options) {
            System.out.println(option);
        }
        String value = ScannerSingleton.instance().getScanner().nextLine();
        Integer option = Integer.valueOf(value);
        if (validOption(option)) {
            executeOption(option);
        } else {
            System.out.println("Opção invalida");
            execute();
        }
    }

    protected abstract Boolean validOption(Integer option);

    protected abstract void executeOption(Integer option);

}
