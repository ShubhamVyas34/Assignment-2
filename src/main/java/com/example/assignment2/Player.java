package com.example.assignment2;

public class Player {

    private String id;
    private String name;
    private String country;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}

