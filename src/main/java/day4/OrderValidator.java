package day4;

import java.util.List;

public class OrderValidator {

    public static void validateOrder(List<Item> items, String customerInfo) {
        hasNoItems(items);
        isNotValidTotalPrice(items);
        hasNotCustomerInfo(customerInfo);
    }

    private static void hasNotCustomerInfo(String customerInfo) {
        if (customerInfo == null || customerInfo.isEmpty()){
            throw new OrderException("사용자 정보가 없습니다.");
        }
    }

    private static void isNotValidTotalPrice(List<Item> items) {
        int totalPrice = calculateTotalPrice(items);
        if (totalPrice <= 0) {
            throw new OrderException("올바르지 않은 총 가격입니다.");
        }
    }

    private static void hasNoItems(List<Item> items) {
        if (items.isEmpty()) {
            throw new OrderException("주문 항목이 없습니다.");
        }
    }

    private static int calculateTotalPrice(List<Item> items) {
        return items.stream().mapToInt(Item::getPrice).sum();
    }
}
