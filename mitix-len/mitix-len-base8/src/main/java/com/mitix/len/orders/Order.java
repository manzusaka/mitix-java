package com.mitix.len.orders;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单的内容
 *
 * @author oldflame-jm
 * @since 1.0.0
 */
public class Order {
    /**
     * 该订单对应的商品
     */
    List<Item> orderItems = new ArrayList<>();

    /**
     * 该订单金额，单位分
     */
    long totalPrice;

    /**
     * 该订单对应的卖家userId
     */
    long sellerId;

    public Order(long sellerId) {
        this.sellerId = sellerId;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderItems=" + orderItems +
                ", totalPrice=" + totalPrice +
                ", sellerId=" + sellerId +
                '}';
    }
}
