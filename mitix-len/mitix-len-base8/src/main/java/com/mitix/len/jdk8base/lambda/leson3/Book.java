package com.mitix.len.jdk8base.lambda.leson3;

import java.util.Date;
import java.util.List;

/**
 * @author oldflame-jm
 * @create 2018/9/7
 * ${DESCRIPTION}
 */
public class Book {
    private String title;
    private List<String> authors;
    private int[] pageCounts;
    private Topic topic;
    private Date pubDate;
    private Double height;

    public Book(String title, List<String> authors, int[] pageCounts, Topic topic, Date pubDate, Double height) {
        this.title = title;
        this.authors = authors;
        this.pageCounts = pageCounts;
        this.topic = topic;
        this.pubDate = pubDate;
        this.height = height;
    }

    public static Book defaule() {
        return null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public int[] getPageCounts() {
        return pageCounts;
    }

    public void setPageCounts(int[] pageCounts) {
        this.pageCounts = pageCounts;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
