package com.nagarro.AdvanceJavaAssignment1.model;

public class UserInput implements Constants {
    private final String color;
    private final String size;
    private final String gender;
    private final int outputPreference;

    public UserInput(String color, String size,
                     String gender, int outputPreference) {
        super();
        this.color = color;
        this.size = size;
        this.gender = gender;
        this.outputPreference = outputPreference;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getGenderRecommendation() {
        return gender;
    }

    public int getOutputPreference() {
        return outputPreference;
    }

    @Override
    public String toString() {
        return "color=" + color + ", size=" + size
                + ", gender=" + gender
                + ", outputPreference=" + outputPreference;
    }
}
