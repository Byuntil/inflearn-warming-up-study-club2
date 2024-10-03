package day4;

import java.util.Collections;
import java.util.List;

public class Order {
    private final List<Item> items;
    private final String customerInfo;

    private Order(List<Item> items, String customerInfo) {
        this.items = (items.isEmpty()) ? Collections.emptyList() : items;
        this.customerInfo = (customerInfo == null) ? "" : customerInfo;
    }

    public static Order create(List<Item> items, String customerInfo) {
        OrderValidator.validateOrder(items, customerInfo);
        return new Order(items, customerInfo);
    }
    //test용으로 열어둠
    public List<Item> getItems() {
        return items;
    }
    //test용으로 열어둠
    public String getCustomerInfo() {
        return customerInfo;
    }
}
