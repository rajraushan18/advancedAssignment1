package com.nagarro.AdvanceJavaAssignment1.model;

public class Tshirt implements Constants {
    private final String id;
    private final String name;
    private final String color;
    private final String gender_recommendation;
    private final String size;
    private final Double price;
    private final Double rating;
    private final boolean availability;
    


    public Tshirt(String id, String name, String color, String gender_recommendation,
                  String size, Double price, Double rating,
                  boolean availability) {
        super();
        this.id = id;
        this.name = name;
        this.color = color;
        this.gender_recommendation = gender_recommendation;
        this.size = size;
        this.price = price;
        this.rating = rating;
        this.availability = availability;
        
    }


    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getGenderRecommendation() {
        return gender_recommendation;
    }

    public String getSize() {
        return size;
    }

    public Double getPrice() {
        return price;
    }

    public Double getRating() {
        return rating;
    }
    
    public boolean isAvailability() {
        return availability;
    }

 
    @Override
    public String toString() {
        return "id=" + id + ", name=" + name
                + ", color=" + color + ", gender_recommendation=" + gender_recommendation
                + ", size=" + size + ", price="
                + price + ", rating=" + rating + ", availability="
                + availability;
    }

  
}
