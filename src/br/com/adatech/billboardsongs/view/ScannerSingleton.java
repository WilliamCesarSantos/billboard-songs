package br.com.adatech.billboardsongs.view;

import java.util.Scanner;

public class ScannerSingleton {
    // Padrão Singleton

    private Scanner scanner = new Scanner(System.in);
    private static final ScannerSingleton SINGLETON = new ScannerSingleton();

    private ScannerSingleton() {}

    public static ScannerSingleton instance() {
        return SINGLETON;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
