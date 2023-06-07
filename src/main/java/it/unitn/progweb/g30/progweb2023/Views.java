package it.unitn.progweb.g30.progweb2023;

import java.io.Serializable;

public class Views implements Serializable {
    private String page;
    private int views;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

}
