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

    public void printOverMaxQuantity() {
        System.out.println("최대 주문 가능 수량은 99개 입니다.");
    }

    public void printOrderStatus(Table table) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        System.out.println(table.orderMenusFormat());
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println("## 최종 결제할 금액");
        System.out.printf("%d원\n", totalPrice);
        lineBreak();
    }
    private void lineBreak() {
        System.out.println();
    }



}
