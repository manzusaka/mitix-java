package com.mitix.len.orders;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 同一卖家的订单集合
 *
 * @author oldflame-jm
 * @since 1.0.0
 */
public class Seller {
    /**
     * 卖家用户id
     */
    final long sellerId;

    /**
     * 该订单金额，单位分
     */
    long totalPrice;

    /**
     * 最小订单数
     */
    long minOrderNumber;

    /**
     * 需要独立订单的数量
     */
    long packageSelfNumber = 0L;

    /**
     * 独立订单商品
     */
    LinkedList<Item> upList;

    /**
     * 可组合订单商品
     */
    LinkedList<Item> lowList;

    /**
     * 该卖家对应的商品
     */
    final List<Item> sellerItems = new ArrayList<>();

    public Seller(long sellerId) {
        this.sellerId = sellerId;
    }

    public List<Item> getSellerItems() {
        return sellerItems;
    }

    public void addTotalPrice(long price) {
        this.totalPrice = totalPrice + price;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void addPackageSelfNumber() {
        this.packageSelfNumber++;
    }

    public long getPackageSelfNumber() {
        return packageSelfNumber;
    }

    public long getMinOrderNumber() {
        return minOrderNumber;
    }

    public void setMinOrderNumber(long minOrderNumber) {
        this.minOrderNumber = minOrderNumber;
    }

    public LinkedList<Item> getUpList() {
        return upList;
    }

    public void setUpList(LinkedList<Item> upList) {
        this.upList = upList;
    }

    public LinkedList<Item> getLowList() {
        return lowList;
    }

    public void setLowList(LinkedList<Item> lowList) {
        this.lowList = lowList;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerId=" + sellerId +
                ", totalPrice=" + totalPrice +
                ", minOrderNumber=" + minOrderNumber +
                ", packageSelfNumber=" + packageSelfNumber +
                ", upList=" + upList +
                ", lowList=" + lowList +
                ", sellerItems=" + sellerItems +
                '}';
    }
}
