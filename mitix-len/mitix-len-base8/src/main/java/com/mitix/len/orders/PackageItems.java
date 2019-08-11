package com.mitix.len.orders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最佳方案处理参数集
 *
 * @author oldflame-jm
 * @since 1.0.0
 */
public class PackageItems {
    /**
     * 卖家用户id
     */
    long sellerId;
    /**
     * 该订单金额，单位分
     */
    long totalPrice;

    int position;

    List<Item> itemList = new ArrayList<>();

    Item[] items;

    public PackageItems(long sellerId, long totalPrice, int position, Item[] items) {
        this.sellerId = sellerId;
        this.totalPrice = totalPrice;
        this.position = position;
        this.items = items;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "PackageItems{" +
                "sellerId=" + sellerId +
                ", totalPrice=" + totalPrice +
                ", position=" + position +
                ", itemList=" + itemList +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
