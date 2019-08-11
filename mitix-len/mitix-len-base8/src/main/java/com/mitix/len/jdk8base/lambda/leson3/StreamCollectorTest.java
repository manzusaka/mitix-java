package com.mitix.len.jdk8base.lambda.leson3;

import org.junit.Test;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author oldflame-jm
 * @create 2018/9/9
 * ${DESCRIPTION}
 */
public class StreamCollectorTest {

    private List<Book> createBooks() {
        BookStreamTest bookStreamTest = new BookStreamTest();
        return bookStreamTest.createBooks();
    }

    /**
     * 测试使用joining方法
     * joining param
     * 1.delimiter 分隔符
     * 2.prefix 前缀
     * 3.suffix 后缀
     * for  example   stream() has   "aaa"   "bbb"  "ccc"
     * joining with ("::","~~","&&")
     * result is ~~aaa::bbb::ccc$$
     */
    @Test
    public void testJoining() {
        List<Book> books = createBooks();
        String concatTitles = books.stream().map(Book::getTitle).collect(Collectors.joining("::", "~~", "$$"));
        System.out.println(concatTitles);
    }

    /**
     * 测试使用joining方法
     * joining param
     * 1.delimiter 分隔符
     * 2.prefix 前缀
     * 3.suffix 后缀
     * for  example   stream() has   "aaa"   "bbb"  "ccc"
     * joining with ("::","~~","&&")
     * result is ~~aaa::bbb::ccc$$
     * <p>
     * <p>
     * 每本书都打印出作者相关的信息
     */
    @Test
    public void testJoining2() {
        List<Book> books = createBooks();
        List<String> booksWithTitle = books.stream().map(book -> book.getAuthors().stream().collect(Collectors.joining("::", book.getTitle(), "$$"))).collect(Collectors.toList());
        for (String tInfo : booksWithTitle) {
            System.out.println(tInfo);
        }
    }

    /**
     * toList   toSet 可以使用toCollection来进行重载
     * <p>
     * 使用String类型也是可以分类的
     * groupingBy   可以进行分组
     * partitiongBy  可以进行自定义分组
     */
    @Test
    public void testToCollection() {
        List<Book> books = createBooks();
        LinkedList<String> booksTitleList = books.stream().map(Book::getTitle).collect(Collectors.toCollection(LinkedList::new));
        System.out.println(booksTitleList.peek());

        Map<String, List<Book>> map = books.stream().collect(Collectors.groupingBy(Book::getTitle));
        System.out.println("info");
    }

    /**
     * 收集器的嵌套重载
     */
    @Test
    public void testToCollectorsNest() {
        List<Book> books = createBooks();
        Map<String, Long> titleRank = books.stream().collect(Collectors.groupingBy(Book::getTitle, Collectors.counting()));
        for (String tstr : titleRank.keySet()) {
            System.out.println("title is {" + tstr + "} and total is {" + titleRank.get(tstr) + "}");
        }
    }

    /**
     * 查找每个主题下作者最多的书
     */
    @Test
    public void testToCollectorsMaxBy() {
        List<Book> books = createBooks();
        Map<String, Optional<Book>> titleRank = books.stream().collect(Collectors.groupingBy(Book::getTitle, Collectors.maxBy(Comparator.comparingInt(book -> book.getAuthors().size()))));

    }

    /**
     * 求图书的页数总和
     * 统计数的卷数   pageCounts.length
     */
    @Test
    public void testToCollectorsSummingInt() {
        List<Book> books = createBooks();
        Map<String, Integer> titleRank = books.stream().collect(Collectors.groupingBy(Book::getTitle, Collectors.summingInt(book -> book.getPageCounts().length)));

    }

    /**
     * 原生值收集容器
     */
    @Test
    public void testSummaryStatistics() {
        List<Book> books = createBooks();
        Map<Topic, IntSummaryStatistics> valStatus = books.stream().collect(Collectors.groupingBy(Book::getTopic, Collectors.summarizingInt(b -> b.getPageCounts().length)));
        System.out.println(valStatus.get(Topic.FICHINT));
    }

    /**
     * reduce
     * 就是通过mapping处理流的部分属性
     */
    @Test
    public void testReduce() {
        List<Book> books = createBooks();
        Map<Topic, String> valStatus = books.stream().collect(Collectors.groupingBy(Book::getTopic, Collectors.mapping(Book::getTitle, Collectors.joining(","))));
        for (Topic topic : valStatus.keySet()) {
            System.out.println("key is {" + topic + "} and val is {" + valStatus.get(topic) + "}");
        }
    }
}
