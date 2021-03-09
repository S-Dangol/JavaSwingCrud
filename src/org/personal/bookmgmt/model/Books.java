package org.personal.bookmgmt.model;

public class Books {

    private int id;

    private String name;

    private String author;
    
    private String publication;
    
    private Double price;
    
     private Double id2;

    public Double getId2() {
        return id2;
    }

    public void setId2(Double id2) {
        this.id2 = id2;
    }

    public Books() {
    }

    public Books(int id, String name, String author, String publication, Double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publication = publication;
        this.price = price;
    }

    public Books(String name, String author, String publication, Double price,Double id2) {
        this.name = name;
        this.author = author;
        this.publication = publication;
        this.price = price;
        this.id2 = id2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    
}
