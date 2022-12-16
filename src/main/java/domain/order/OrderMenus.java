package domain.order;

import domain.Menu;
import java.util.HashMap;
import java.util.Map;

public class OrderMenus {
    private static final int MAX_QUANTITY = 99;
    private final Map<Menu, Integer> orders = new HashMap<>();

    public void addMenu(Menu menu, int quantity) {
        Integer existQuantity = orders.computeIfAbsent(menu, m -> 0);
        int totalQuantity = existQuantity + quantity;
        if (totalQuantity > MAX_QUANTITY) {
            throw new IllegalArgumentException();
        }

        orders.put(menu, totalQuantity);
    }

    public String format() {
        StringBuilder sb = new StringBuilder();
        String stringFormat = "%s %d %d\n";
        for (Menu menu : orders.keySet()) {
            Integer quantity = orders.get(menu);
            String name = menu.getName();
            int totalPrice = quantity * menu.getPrice();
            sb.append(String.format(stringFormat, name, quantity, totalPrice));
        }
        return sb.toString();
    }

    public int getTotalPrice() {
        return 0;
    }
}
