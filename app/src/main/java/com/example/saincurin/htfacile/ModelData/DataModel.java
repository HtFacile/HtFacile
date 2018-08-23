package com.example.saincurin.htfacile.ModelData;

public class DataModel {

    private String  description;
    private String name;
    private String image;
    private String price;
    private String quantity;


    //constructor
    public DataModel() {

    }

    public DataModel(String name, /*String description,*/ String image, String price) {
        this.name = name;
//        this.description = description;
        this.image = image;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
