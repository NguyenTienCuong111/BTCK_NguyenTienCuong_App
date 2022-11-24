package com.example.cuong_btck_app;

public class SpecialOffers {
    private int resource_image;
    private String name_food_so,price_so;

    public SpecialOffers(int resource_image, String name_food_so, String price_so) {
        this.resource_image = resource_image;
        this.name_food_so = name_food_so;
        this.price_so = price_so;
    }

    public int getResource_image() {
        return resource_image;
    }

    public void setResource_image(int resource_image) {
        this.resource_image = resource_image;
    }

    public String getName_food_so() {
        return name_food_so;
    }

    public void setName_food_so(String name_food_so) {
        this.name_food_so = name_food_so;
    }

    public String getPrice_so() {
        return price_so;
    }

    public void setPrice_so(String price_so) {
        this.price_so = price_so;
    }
}
