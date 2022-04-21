package com.example.mytradingapp.Shared.Transferobjects;

public class News {

    private String symbol;
    private String publishedDate;
    private String title;
    private String image;
    private String text;
    private String url;

    public News(String symbol, String publishedDate, String title, String image, String text, String url) {
        this.symbol = symbol;
        this.publishedDate = publishedDate;
        this.title = title;
        this.image = image;
        this.text = text;
        this.url = url;
    }


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
