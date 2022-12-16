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
}
