package com.example.springHW.controller;

public class Team {

    public int id;
    public String name;
    public String country;
    public String league;
    public int titles;
    public double rating;

    public Team() {
    }

    public Team(int id, String name, String country, String league, int titles, double rating) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.league = league;
        this.titles = titles;
        this.rating = rating;
    }
}