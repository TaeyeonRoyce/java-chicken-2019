package domain.table;

import domain.Menu;
import domain.order.OrderMenus;
import domain.order.PaymentMethod;
import java.util.Map;

public class Table {
    private final int number;
    private TableStatus tableStatus = TableStatus.READY;
    private OrderMenus orderMenus = new OrderMenus();

    public Table(final int number) {
        this.number = number;
    }

    public boolean matchNumber(int tableNumber) {
        return this.number == tableNumber;
    }

    public int getNumber() {
        return number;
    }

    public String topLine() {
        return TableOutputFormat.TOP_LINE.getFormat();
    }

    public String tableFormat() {
        String middleLineFormat = TableOutputFormat.TABLE_FORMAT.getFormat();
        return String.format(middleLineFormat, number);
    }

    public String bottomLine() {
        if (tableStatus == TableStatus.READY) {
            return TableOutputFormat.BOTTOM_LINE.getFormat();
        }

        return TableOutputFormat.BOTTOM_LINE_ORDERED.getFormat();
    }

    public void enrollOrder(Menu menu, int quantity) {
        orderMenus.addMenu(menu, quantity);
        tableStatus = TableStatus.ORDERED;
    }

    public String orderMenusFormat() {
        return orderMenus.format();
    }

    public int payWith(PaymentMethod paymentMethod) {
        int totalPrice = orderMenus.getTotalPrice();
        if (paymentMethod == PaymentMethod.CASH) {
            totalPrice *= 0.95;
        }
        this.tableStatus = TableStatus.READY;
        return totalPrice;
    }
}
