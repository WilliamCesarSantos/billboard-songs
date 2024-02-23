package br.com.adatech.billboardsongs.view.component.table;

public class TableView {

    private Integer size = 20;

    public void execute(
            String[] headers,
            String[][] lines
    ) {
        showHeaders(headers);
        showLines(lines);
    }

    private void showHeaders(String[] headers) {
        for (String header : headers) {
            System.out.print("| ");
            System.out.print(String.format("%-" + size + "s", header));
        }
        System.out.println(" |");
    }

    private void showLines(String[][] lines) {
        for (String[] line : lines) {
            for (String column : line) {
                System.out.print("| ");
                System.out.print(String.format("%-" + size + "s", column));
            }
            System.out.println(" |");
        }
    }

}
