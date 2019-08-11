package com.mitix.len.orders;

/**
 * 商品的内容
 *
 * @author oldflame-jm
 * @since 1.0.0
 */
public class Item {
    /**
     * 卖家用户id
     */
    long sellerId;

    /**
     * 商品价格，单位分
     */
    long price;

    public Item(long sellerId, long price) {
        this.price = price;
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "sellerId=" + sellerId +
                ", price=" + price +
                '}';
    }
}
