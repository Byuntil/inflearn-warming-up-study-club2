package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(new Item("색연필", 2000), new Item("만연필", 10000));
        Order order = Order.create(items, "구성재");
    }
}
