package com.mitix.len.orders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author oldflame-jm
 * @create 2018/5/4
 * ${DESCRIPTION}
 */
public class SplitOrders {

    /**
     * 每个订单的总价格上限单位分
     */
    static final long PACKET_PRICE = 100000L;
    /**
     * 订单算法的阈值
     */
    static final long PACKET_NUMBER_THRESHOLD = 5L;
    /**
     * 平均订单颗粒度阈值，当一个订单有无数小商品时，使用最佳排序效率低
     */
    static final long PACKET_PARTICL_THRESHOLD = 10L;

    /**
     * 根据购物车的商品，生成相应的交易订单，根据如下规则
     * 1.每笔交易订单可以有多个商品
     * 2.每笔交易订单的商品只能是同一个卖家
     * 3.每笔交易商品的总价格不能超过1000元
     * 4.生成的交易订单数量最小
     *
     * @param items：购物车所有商品
     */
    public List<Order> packageItemsToOrders(List<Item> items) {
        //快速返回
        if (items == null || items.isEmpty()) {
            return new ArrayList<>();
        }
        //先针对卖家进行订单分组
        Map<Long, Seller> sellerMap = groupWithSeller(items);
        List<Order> orderList = new ArrayList<>();
        Iterator<Map.Entry<Long, Seller>> iterator = sellerMap.entrySet().iterator();
        while (iterator.hasNext()) {
            //进行订单打包
            orderList.addAll(packageItemsToOrdersSameSeller(iterator.next().getValue()));
        }
        return orderList;
    }

    /**
     * 根据卖家进行商品分组
     *
     * @param items 购物车所有商品
     * @return
     */
    private Map<Long, Seller> groupWithSeller(List<Item> items) {
        Map<Long, Seller> sellerMap = new HashMap<>();
        for (Iterator<Item> iterator = items.iterator(); iterator.hasNext(); ) {
            Item item = iterator.next();
            if (sellerMap.get(item.sellerId) == null) {
                sellerMap.put(item.sellerId, new Seller(item.sellerId));
            }
            Seller seller = sellerMap.get(item.sellerId);
            seller.getSellerItems().add(item);
            seller.addTotalPrice(item.price);
            //顺便标注需要独立生成订单的商品数量
            if (item.price > PACKET_PRICE / 2) {
                seller.addPackageSelfNumber();
            }
        }
        return sellerMap;
    }

    /**
     * 同意卖家按照每个订单价格不超过1000进行合并
     * 寻找合并方案
     *
     * @param seller 同一卖家商品集
     * @return
     */
    private Collection<? extends Order> packageItemsToOrdersSameSeller(Seller seller) {
        //估算最小的订单数量，实际订单数量可能会大于这个数，当订单最小数量为估算值时就是最佳方案  尽量优化订单计算的复杂度
        if (seller.getTotalPrice() % PACKET_PRICE == 0L) {
            seller.setMinOrderNumber((seller.getTotalPrice() / PACKET_PRICE) > seller.getPackageSelfNumber() ? seller.getTotalPrice() / PACKET_PRICE : seller.getPackageSelfNumber());
        } else {
            seller.setMinOrderNumber(((seller.getTotalPrice() / PACKET_PRICE) + 1) > seller.getPackageSelfNumber() ? (seller.getTotalPrice() / PACKET_PRICE) + 1 : seller.getPackageSelfNumber());
        }
        //进行排序
        splitItems(seller);
        //当订单数量很大的时候  用穷举法推算最佳方案不可行，而且多一个订单对于订单总数的误差率不大
        //100  200 300 600 800的价格方法1不能正确合并订单  误差会很大
        if (seller.getMinOrderNumber() > PACKET_NUMBER_THRESHOLD || (seller.getSellerItems().size() / seller.getMinOrderNumber()) > PACKET_PARTICL_THRESHOLD) {
            return packageItemsQuick(seller);
        } else {
            //当订单数量少的时候  比如2个订单和3个订单  订单的误差率非常大  采用最佳方案
            return packageItemsBest(seller);
        }
    }

    /**
     * 寻找最佳的订单组合方案
     *
     * @param seller 同一卖家商品集
     */

    private List<Order> packageItemsBest(Seller seller) {
        List<Order> orderList = new ArrayList<>();

        doPackageItemsBest(seller.sellerId, orderList, seller.getUpList(), seller.getLowList());

        if (orderList.size() == seller.getMinOrderNumber()) {
            System.out.println("最佳排序结果校验,肯定是最优方案");
        }

        return orderList;
    }

    /**
     * 1.在前面利用卖家分组订单的时候已经知道哪些订单要独立生成订单了
     * 2.按照需要独立生成订单的集合价格从大到小开始处理
     * 3.采用递归 随机一个个把商品放入订单进行尝试  放入以后进行校验没有超出总金额的就是有可能的可行防范  再放入下一个
     * 4.当金额刚好=PACKET_PRICE总金额的时候  满足这个箱子总金额最佳   放入的商品数量最小（变化的可能性最小）认为最佳
     * 因为订单中的第一个商品的价格都是从大到小倒叙的  最小的商品数量的总价格如果还有一样的放入下一个也一定可以放进去
     * 5.小价格商品都处理完则其余大的订单都不能合并单张生成
     * 6.大价格商品先处理完 那按照小价格商品中拿出最大价格的一件商品 然后尝试合并其他商品
     *
     * @param sellerId
     * @param orderList
     * @param upList
     * @param lowList
     */
    private void doPackageItemsBest(long sellerId, List<Order> orderList, LinkedList<Item> upList, LinkedList<Item> lowList) {
        Order order = new Order(sellerId);
        //需要单独订单的价格最大的商品
        if (upList.peekLast() != null) {
            Item item = upList.pollLast();
            order.setTotalPrice(order.getTotalPrice() + item.price);
            order.orderItems.add(item);
            //默认一件商品就超过PACKET_PRICE 价格则直接处理第二个
            if (order.getTotalPrice() >= PACKET_PRICE) {
                orderList.add(order);
                //做下一次商品订单处理
                doPackageItemsBest(sellerId, orderList, upList, lowList);
            }
            //生成一个订单
            packageOne(order, lowList);
            orderList.add(order);
            //做下一次商品订单处理
            doPackageItemsBest(sellerId, orderList, upList, lowList);
        } else { //独立生成订单的商品已经完结

            //从可以合并的商品中拿出最大的一个
            if (lowList.peekLast() != null) {
                Item item = lowList.pollLast();
                order.setTotalPrice(order.getTotalPrice() + item.price);
                order.orderItems.add(item);
                //生成一个订单
                packageOne(order, lowList);
                orderList.add(order);
                //做下一次商品订单处理
                doPackageItemsQuick(sellerId, orderList, upList, lowList);
            } else {//所有的商品都已经处理完结
                return;
            }
        }
    }

    /**
     * 选定一个最大价格的商品  尝试添加剩余的商品
     *
     * @param order
     * @param lowList
     */
    private void packageOne(Order order, LinkedList<Item> lowList) {
        //如果已经没有数据要放入订单了  直接返回
        if (lowList.isEmpty()) {
            return;
        }
        List<PackageItems> packageItemsList = new ArrayList<>();
        Item[] items = lowList.toArray(new Item[lowList.size()]);
        PackageItems packageItems = new PackageItems(order.sellerId, order.getTotalPrice(), 0, items);
        doPackageOne(packageItemsList, packageItems);
        if (!packageItemsList.isEmpty()) {
            //倒叙
            packageItemsList.sort(new Comparator<PackageItems>() {
                @Override
                public int compare(PackageItems p1, PackageItems p2) {
                    if (p1.getTotalPrice() > p2.getTotalPrice()) {
                        return -1;
                    } else if (p1.getTotalPrice() < p2.getTotalPrice()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
            PackageItems packageItems1 = packageItemsList.get(0);
            order.setTotalPrice(packageItems1.getTotalPrice());
            order.orderItems.addAll(packageItems1.getItemList());
            //选中了最优方案  把元素过滤出去
            for (int i = lowList.size() - 1; i >= 0; i--) {
                Item item = lowList.get(i);
                for (Item item1 : packageItems1.getItemList()) {
                    if (item.equals(item1)) {
                        lowList.remove(i);
                    }
                }
            }
        }
    }

    /**
     * 利用递归寻找最佳的添加方案
     *
     * @param packageItemsList
     * @param packageItems
     */
    private void doPackageOne(List<PackageItems> packageItemsList, PackageItems packageItems) {
        Item[] itemsToUse = packageItems.getItems();
        int positionToUse = packageItems.getPosition();
        for (int i = positionToUse; i < itemsToUse.length; i++) {
            long totalPriceToUse = packageItems.getTotalPrice();
            Item item = itemsToUse[i];
            //如果是小于的  可能还能放入下一个商品
            if ((totalPriceToUse + item.price) < PACKET_PRICE) {
                PackageItems p = new PackageItems(packageItems.getSellerId(), totalPriceToUse + item.price, i + 1, packageItems.getItems());
                if (!packageItems.getItemList().isEmpty()) {
                    p.getItemList().addAll(packageItems.getItemList());
                }
                p.getItemList().add(item);
                packageItemsList.add(p);
                //如果还有尝试继续添加
                if (positionToUse < itemsToUse.length) {
                    doPackageOne(packageItemsList, p);
                }
            } else if (totalPriceToUse + item.price == PACKET_PRICE) {
                //如果是等于的  当前刚好满足 已经是放入最少商品的方案 无需继续迭代
                PackageItems p = new PackageItems(packageItems.getSellerId(), totalPriceToUse + item.price, i + 1, packageItems.getItems());
                if (!packageItems.getItemList().isEmpty()) {
                    p.getItemList().addAll(packageItems.getItemList());
                }
                p.getItemList().add(item);
                packageItemsList.add(p);
                break;
            } else {
                //如果是大于的 后续全部不需要处理了
                break;
            }
        }
    }


    /**
     * 快速找出相对较好的订单组合方案
     * 详细看doPackageItemsQuick方法
     *
     * @param seller 同一卖家商品集
     */
    private List<Order> packageItemsQuick(Seller seller) {

        List<Order> orderList = new ArrayList<>();
        //快速递归处理商品
        doPackageItemsQuick(seller.sellerId, orderList, seller.getUpList(), seller.getLowList());

        if (orderList.size() == seller.getMinOrderNumber()) {
            System.out.println("快速匹配到了最佳方案");
        }

        return orderList;
    }

    /**
     * 拆分可以独立订单和可以组装订单的商品
     *
     * @param seller 同一卖家商品集
     */
    private void splitItems(Seller seller) {
        List<Item> list = seller.getSellerItems();
        list.sort(new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                if (item1.price >= item2.price) {
                    return 1;
                } else if (item1.price < item2.price) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        //确定大于总价一半的商品的数量 必须拆分订单
        int i;
        for (i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).price <= PACKET_PRICE / 2) {
                break;
            }
        }
        seller.setLowList(new LinkedList<>(list.subList(0, i + 1)));
        seller.setUpList(new LinkedList<>(list.subList(i + 1, list.size())));
    }

    /**
     * 递归快速合并方案
     * 1.在前面利用卖家分组订单的时候已经知道哪些订单要独立生成订单了
     * 2.按照需要独立生成订单的集合价格从大到小开始处理  然后尝试合并有可能可以合并的订单集合从小到大
     * 3.如果合并以后生成的订单价格>PACKET_PRICE 那就失败合并下一张订单
     * 3.小价格商品都处理完则其余大的订单都不能合并单张生成
     * 4.大价格商品先处理完 那按照小价格商品中拿出最大价格的一件商品 然后尝试合并其他商品
     * <p>
     * <p>
     * 本方法适用于订单量非常多或者单个订单上有很多小商品
     * 当商品非常多的时候  商品订单不是最佳排序造成的误差浪费比较新  排序效率高
     *
     * @param orderList 订单集合
     * @param upList    需要独立拆分订单的商品集合
     * @param lowList   可以组合的商品集合
     */
    private void doPackageItemsQuick(long sellerId, List<Order> orderList, LinkedList<Item> upList, LinkedList<Item> lowList) {
        Order order = new Order(sellerId);
        //需要单独订单的价格最大的商品
        if (upList.peekLast() != null) {
            Item item = upList.pollLast();
            order.setTotalPrice(order.getTotalPrice() + item.price);
            order.orderItems.add(item);
            //默认一件商品就超过PACKET_PRICE 价格则直接处理第二个
            if (order.getTotalPrice() >= PACKET_PRICE) {
                orderList.add(order);
                //做下一次商品订单处理
                doPackageItemsQuick(sellerId, orderList, upList, lowList);
            }
            while (lowList.peekFirst() != null) {
                if (order.getTotalPrice() + lowList.peekFirst().price <= PACKET_PRICE) {
                    Item item1 = lowList.pollFirst();
                    order.setTotalPrice(order.getTotalPrice() + item1.price);
                    order.orderItems.add(item1);
                } else {
                    break;
                }
            }
            orderList.add(order);
            //做下一次商品订单处理
            doPackageItemsQuick(sellerId, orderList, upList, lowList);
        } else { //独立生成订单的商品已经完结

            //从可以合并的商品中拿出最大的一个
            if (lowList.peekLast() != null) {
                Item item = lowList.pollLast();
                order.setTotalPrice(order.getTotalPrice() + item.price);
                order.orderItems.add(item);
                while (lowList.peekFirst() != null) {
                    if (order.getTotalPrice() + lowList.peekFirst().price <= PACKET_PRICE) {
                        Item item1 = lowList.pollFirst();
                        order.setTotalPrice(order.getTotalPrice() + item1.price);
                        order.orderItems.add(item1);
                    } else {
                        break;
                    }
                }
                orderList.add(order);
                //做下一次商品订单处理
                doPackageItemsQuick(sellerId, orderList, upList, lowList);
            } else {//所有的商品都已经处理完结
                return;
            }
        }
    }
}
