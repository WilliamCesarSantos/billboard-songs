package br.com.adatech.billboardsongs.view.component.table;

public class TableView {

    public void execute(
            String[] headers,
            String[][] lines
    ) {
        showColumn(headers);
        showLines(lines);
    }

    private void showColumn(String[] headers) {
        System.out.print("| ");
        for (String column : headers) {
            System.out.print(column);
            System.out.print("    | ");
        }
        System.out.println();
    }

    private void showLines(String[][] lines) {
        for (String[] line : lines) {
            System.out.print("| ");
            for (String column : line) {
                System.out.print(column);
                System.out.print("    | ");
            }
            System.out.println();
        }
    }

}
