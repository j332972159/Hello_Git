package com.pccc.es.elasticsearch_demo.pojo;

/**
 * @Author jinquanhua
 * @date 2020/6/25 10:15
 */


public class Article {
    private long id;
    private String title;
    private String content;

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
