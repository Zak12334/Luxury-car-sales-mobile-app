package com.example.assignment;

public class Vehicle {
    private int imageResId;
    private String name;
    private String year;
    private String price;
    private String vehicleType;

    public Vehicle(int imageResId, String name, String year, String price, String vehicleType) {
        this.imageResId = imageResId;
        this.name = name;
        this.year = year;
        this.price = price;
        this.vehicleType = vehicleType; // Initialize the vehicle type
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getPrice() {
        return price;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}
