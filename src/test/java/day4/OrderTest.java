package day4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    @DisplayName("주문 생성 성공")
    void OrderTestSuccess() {
        // given
        List<Item> items = List.of(new Item("item1",1000), new Item("item2",2000));
        String customerInfo = "구성재";
        // when
        Order order = Order.create(items, customerInfo);
        // then
        assertEquals(customerInfo, order.getCustomerInfo());
        assertEquals(items, order.getItems());
    }

    @Test
    @DisplayName("주문 성성 실패")
    void OrderTestFail() {
        // given
        List<Item> items = List.of(new Item("item1",1000), new Item("item2",-1000));
        String customerInfo = "구성재";
        // when & then
        assertThrows(OrderException.class, () -> Order.create(items, customerInfo));
    }
}