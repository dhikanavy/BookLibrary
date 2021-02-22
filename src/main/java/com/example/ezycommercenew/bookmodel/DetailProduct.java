package com.example.ezycommercenew.bookmodel;

public class DetailProduct {
    private Integer id;
    private String name, type, img, category, author;
    private String description;
    private Double price;
    private Boolean inCart;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getImg() {
        return img;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getInCart() {
        return inCart;
    }
}
