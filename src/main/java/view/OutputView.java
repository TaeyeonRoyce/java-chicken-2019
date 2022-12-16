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
    }

    public void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        for (Table table : tables) {
            System.out.print(table.topLine());
        }
        System.out.println();

        for (Table table : tables) {
            System.out.print(table.tableFormat());
        }
        System.out.println();

        for (Table table : tables) {
            System.out.print(table.bottomLine());
        }
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }
}
