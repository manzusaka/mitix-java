package com.mitix.len.jdk8base.lambda.leson3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author oldflame-jm
 * @create 2018/9/7
 * ${DESCRIPTION}
 */
public class BookStreamTest {

    public List<Book> createBooks() {
        Book springboot = new Book("Spring boot", Arrays.asList("hong", "li", "zhang"), new int[]{488}, Topic.HISTORY, new Date(2007, 1, 01), 312.11);
        Book netty = new Book("netty is a  hig lu", Arrays.asList("la", "dd"), new int[]{301}, Topic.PROGRAMMING, new Date(2014, 11, 01), 188.34);
        Book postgresql = new Book("postgresql  good sql", Arrays.asList("nini", "ho", "bilibili", "nani"), new int[]{1314, 520, 338}, Topic.HISTORY, new Date(2017, 8, 18), 89.2);
        Book web = new Book("html5 css jquery  vue", Arrays.asList("chui", "niu", "bi", "wo", "shi", "keyi"), new int[]{258, 110}, Topic.FICHINT, new Date(2013, 9, 22), 212.11);
        Book springboot2 = new Book("Spring boot", Arrays.asList("hong", "li", "zhang2"), new int[]{733}, Topic.HISTORY, new Date(2016, 1, 01), 352.25);

        List<Book> books = new ArrayList<>();
        books.add(springboot);
        books.add(springboot2);
        books.add(netty);
        books.add(postgresql);
        books.add(web);
        return books;
    }

    /**
     * 测试filter方法
     * 元素过滤：对Stream对象按指定的Predicate进行过滤，返回的Stream对象中仅包含未被过滤的元素
     */
    @Test
    public void testFilter() {
        List<Book> books = createBooks();
        List<Book> result = books.parallelStream().filter(book -> book.getTopic() == Topic.HISTORY).collect(Collectors.toList());
        for (Book book : result) {
            System.out.println("title is {" + book.getTitle() + "} and topic is {" + book.getTopic() + "}");
        }
    }


    /**
     * 测试map方法
     * 元素一对一转换：使用传入的Function对象对Stream中的所有元素进行处理，返回的Stream对象中的元素为原元素处理后的结果
     * <p>
     * min 根据比较器求出最小值
     */
    @Test
    public void testMap() {
        List<Book> books = createBooks();
        List<Book> results = books.stream().map(book -> {
            book.setHeight(book.getHeight() + 200);
            return book;
        }).collect(Collectors.toList());

        for (Book book : results) {
            System.out.println("title is {" + book.getTitle() + "} and height is {" + book.getHeight() + "}");
        }

        Book bookret = books.stream().map(book -> {
            book.setHeight(book.getHeight() + 200);
            return book;
        }).min(Comparator.comparing(book -> book.getHeight())).orElse(null);

        //测试orElseGet
        Book bookret2 = books.stream().map(book -> {
            book.setHeight(book.getHeight() + 200);
            return book;
        }).min(Comparator.comparing(book -> book.getHeight())).orElseGet(() -> Book.defaule());
        System.out.println("this book title is {" + bookret.getTitle() + "}");
    }

    /**
     * 测试  mapToInt
     * 元素一对一转换：加工以后放入IntStream
     * <p>
     * min
     * 返回所有元素中最小值的Optional对象；如果Stream中无任何元素，那么返回的Optional对象为Empty
     */
    @Test
    public void mapToInt() {
        List<Book> books = createBooks();
        int mins = books.stream().mapToInt(book -> book.getAuthors().size()).min().getAsInt();
        System.out.println("this size mins is {" + mins + "}");
    }

    /**
     * 测试  mapToInt
     * 元素一对一转换：加工以后放入DoubleStream
     */
    @Test
    public void mapToDouble() {
        List<Book> books = createBooks();
        double nums = books.stream().mapToDouble(book -> book.getHeight() + 500).sum();
        System.out.println("this height sum is {" + nums + "}");
    }


    /**
     * flatMap
     * 元素一对多转换 ，每个元素都会转成1个或者多个流然后统一的输出
     */
    @Test
    public void testFlatMap() {

        List<Book> books = createBooks();
        List<String> authors = books.stream().flatMap(book -> book.getAuthors().stream()).distinct().collect(Collectors.toList());
        for (String author : authors) {
            System.out.println(" author name is {" + author + "}");
        }
    }

    /**
     * peek ： 使用传入的Consumer对象对所有元素进行消费后，返回一个新的包含所有原来元素的Stream对象，
     * 目的旨在对管道中间位置的元素进行处理。
     */
    @Test
    public void testPeek() {
        List<Book> books = createBooks();

        books.parallelStream().filter(book -> book.getTopic() == Topic.HISTORY)
                .peek(book -> System.out.println(book.getTitle()));

        List<Book> results = books.parallelStream().filter(book -> book.getTopic() == Topic.HISTORY)
                .peek(book -> System.out.println(book.getTitle())).filter(book -> book.getAuthors().size() > 3).collect(Collectors.toList());

        for (Book book : results) {
            System.out.println("this book title is {" + book.getTitle() + "}");
        }
    }

    /**
     * 测试排序和去重
     */
    @Test
    public void testStoredAndDistinct() {
        List<Book> books = createBooks();
        for (Book book : books) {
            System.out.println("stord before book is  {" + book.getTitle() + "}");
        }
        List<Book> result = books.stream()
                .sorted(Comparator.comparingInt(b -> b.getPageCounts()[0])).distinct()
                .collect(Collectors.toCollection(LinkedList::new));

        for (Book book1 : result) {
            System.out.println("stord after book is  {" + book1.getTitle() + "}");
        }
    }

    /**
     * 截断  skip 前面截断
     * limit 后面截断
     */
    @Test
    public void testSkipAndLimit() {
        List<Book> books = createBooks();
        List<Book> result = books.stream().skip(1).limit(2).collect(Collectors.toList());
        for (Book book1 : result) {
            System.out.println("skip and limit book is  {" + book1.getTitle() + "}");
        }

        List<Book> result2 = books.stream().limit(2).skip(1).collect(Collectors.toList());
        for (Book book1 : result2) {
            System.out.println("limit and skip book is  {" + book1.getTitle() + "}");
        }
    }


    /**
     * 自燃排序
     */
    @Test
    public void testnaturalOrder() {
        List<Book> books = createBooks();
        List<String> result = books.stream().map(Book::getTitle).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        for (String title : result) {
            System.out.println("this is title is {" + title + "}");
        }
    }


    /**
     * 自然倒叙
     */
    @Test
    public void testReverseOrder() {
        List<Book> books = createBooks();
        List<String> result = books.stream().map(Book::getTitle).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (String title : result) {
            System.out.println("this is title is {" + title + "}");
        }
    }

    /**
     * 测试toMap的方式
     */
    @Test
    public void testToMap() {
        List<Book> books = createBooks();
        Map<String, Book> bookMap = books.stream().collect(Collectors.toMap(book -> book.getTitle(), book -> book));
        Set<String> tSet = bookMap.keySet();
        for (String title : tSet) {
            System.out.println("set is {" + title + "} and book is {" + bookMap.get(title) + "}");
        }
    }

    /**
     * 收集汇聚功能
     */
    @Test
    public void testCollect() {
        List<Book> books = createBooks();

        //根据主题对图书进行分类
        Map<Topic, List<Book>> tbooks = books.stream().collect(Collectors.groupingBy(Book::getTopic));

        //从图书标题映射到最新版发布日期的有序map
        Map<String, Date> titleToPubDate = books.stream().collect(Collectors.toMap(Book::getTitle, Book::getPubDate, BinaryOperator.maxBy(Comparator.naturalOrder()), TreeMap::new));

        //划分小说还是非小说类型
        Map<Boolean, List<Book>> fictionOrNon = books.stream().collect(Collectors.partitioningBy(book -> book.getTopic() == Topic.FICHINT));

        //----还有很多类型

    }
}
