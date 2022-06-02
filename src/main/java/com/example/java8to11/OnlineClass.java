package com.example.java8to11;

public class OnlineClass {

    private Integer id;
    private String title;
    private Boolean closed;

    public OnlineClass() {}

    public OnlineClass(Integer id, String title, Boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Boolean getClosed() {
        return this.closed;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

}
