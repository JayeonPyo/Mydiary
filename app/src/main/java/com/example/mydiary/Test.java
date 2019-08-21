package com.example.mydiary;

public class Test {

    private String url;
    private String genre;
    private String title;
    private String content;

    public Test(String url, String genre, String title, String content) {

        this.url = url;
        this.genre = genre;
        this.title = title;
        this.content = content;

    }

    public String getUrl() {
        return url;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}

