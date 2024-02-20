package br.com.adatech.billboardsongs.view;

import java.util.Scanner;

public abstract class AbstractMenuView {

    private String[] options;

    public AbstractMenuView(String[] options) {
        this.options = options;
    }

    public void execute(){
        System.out.println("Escolha uma opção:");
        for (String option : options) {
            System.out.println(option);
        }
        Scanner scanner = new Scanner(System.in);
        Integer option = scanner.nextInt();
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
