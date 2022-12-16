package view;

import domain.pos.PosJob;
import domain.Menu;
import domain.table.Table;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static OutputView getInstance() {
        return new OutputView();
    }

    public void mainView(PosJob[] posJobs) {
        System.out.println("## 메인화면");
        for (PosJob posJob : posJobs) {
            System.out.println(posJob.outputFormat());
        }
        lineBreak();
    }

    public void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        printTopLine(tables);
        printTableLine(tables);
        printBottomLine(tables);
        lineBreak();
    }

    private void printTopLine(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.print(table.topLine());
        }
        lineBreak();
    }

    private void printTableLine(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.print(table.tableFormat());
        }
        lineBreak();
    }

    private void printBottomLine(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.print(table.bottomLine());
        }
        lineBreak();
    }

    public void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }

        lineBreak();
    }

    private void lineBreak() {
        System.out.println();
    }
}
