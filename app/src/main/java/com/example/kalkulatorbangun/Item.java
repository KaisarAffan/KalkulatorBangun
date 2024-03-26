package com.example.kalkulatorbangun;

public class Item {
    private int image;
    private String Title;
    private String Description;

    public Item(int image, String title, String description) {
        this.image = image;
        this.Title = title;
        this.Description = description;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }
}
