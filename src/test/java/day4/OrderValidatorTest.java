package day4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderValidatorTest {
    @Test
    @DisplayName("주문 생성시 아이템이 없으면 예외가 발생한다")
    void hasNoItemTest() {
        // given
        List<Item> items = Collections.EMPTY_LIST;
        String customerInfo = "고객 정보";
        // when & then
        String message = assertThrows(OrderException.class, () -> OrderValidator.validateOrder(items, customerInfo)).getMessage();
        System.out.println("message = " + message);
    }

    @Test
    @DisplayName("주문 생성시 사용자 정보가 없으면 예외가 발생한다")
    void isNotValidTotalPriceTest() {
        // given
        List<Item> items = List.of(new Item("item1",1000));
        String customerInfo = "";
        // when & then
        String message = assertThrows(OrderException.class, () -> OrderValidator.validateOrder(items, customerInfo)).getMessage();
        System.out.println("message = " + message);
    }

    @Test
    @DisplayName("주문 생성시 올바르지 않은 가격 합 일때 예외가 발생한다")
    void isNotValidTotalPrice() {
        // given
        List<Item> items = List.of(new Item("item1",-1000), new Item("item2",1000));
        String customerInfo = "고객 정보";
        // when & then
        String message = assertThrows(OrderException.class, () -> OrderValidator.validateOrder(items, customerInfo)).getMessage();
        System.out.println("message = " + message);
    }
}