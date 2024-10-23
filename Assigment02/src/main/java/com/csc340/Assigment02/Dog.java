package com.csc340.Assigment02;

public class Dog {
    private String breed;
    private String imageURL;

    // Constructor, getters, and setters
    public Dog(String breed, String imageURL) {
        this.breed = breed;
        this.imageURL = imageURL;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
