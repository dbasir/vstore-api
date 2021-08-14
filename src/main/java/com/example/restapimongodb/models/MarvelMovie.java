package com.example.restapimongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("marvelmovies")
public class MarvelMovie
{
    @Id
    private String id;
    private String marvel_title;
    private double marvel_price;
    private String marvel_synopsis;
    private String marvel_tag;    //Marvel or DC or TV Shows
    private String marvel_small_poster;
    private String marvel_large_poster;
    private double marvel_rent;
    private double marvel_purchase_outright;
    private String marvel_featured; //yes or no
    private String marvel_description;

    public MarvelMovie(){}

    public MarvelMovie(String id, String marvel_title, double marvel_price, String marvel_synopsis, String marvel_tag, String marvel_small_poster, String marvel_large_poster, double marvel_rent, double marvel_purchase_outright, String marvel_featured, String marvel_description) {
        this.id = id;
        this.marvel_title = marvel_title;
        this.marvel_price = marvel_price;
        this.marvel_synopsis = marvel_synopsis;
        this.marvel_tag = marvel_tag;
        this.marvel_small_poster = marvel_small_poster;
        this.marvel_large_poster = marvel_large_poster;
        this.marvel_rent = marvel_rent;
        this.marvel_purchase_outright = marvel_purchase_outright;
        this.marvel_featured = marvel_featured;
        this.marvel_description = marvel_description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarvel_title() {
        return marvel_title;
    }

    public void setMarvel_title(String marvel_title) {
        this.marvel_title = marvel_title;
    }

    public double getMarvel_price() {
        return marvel_price;
    }

    public void setMarvel_price(double marvel_price) {
        this.marvel_price = marvel_price;
    }

    public String getMarvel_synopsis() {
        return marvel_synopsis;
    }

    public void setMarvel_synopsis(String marvel_synopsis) {
        this.marvel_synopsis = marvel_synopsis;
    }

    public String getMarvel_tag() {
        return marvel_tag;
    }

    public void setMarvel_tag(String marvel_tag) {
        this.marvel_tag = marvel_tag;
    }

    public String getMarvel_small_poster() {
        return marvel_small_poster;
    }

    public void setMarvel_small_poster(String marvel_small_poster) {
        this.marvel_small_poster = marvel_small_poster;
    }

    public String getMarvel_large_poster() {
        return marvel_large_poster;
    }

    public void setMarvel_large_poster(String marvel_large_poster) {
        this.marvel_large_poster = marvel_large_poster;
    }

    public double getMarvel_rent() {
        return marvel_rent;
    }

    public void setMarvel_rent(double marvel_rent) {
        this.marvel_rent = marvel_rent;
    }

    public double getMarvel_purchase_outright() {
        return marvel_purchase_outright;
    }

    public void setMarvel_purchase_outright(double marvel_purchase_outright) {
        this.marvel_purchase_outright = marvel_purchase_outright;
    }

    public String getMarvel_featured() {
        return marvel_featured;
    }

    public void setMarvel_featured(String marvel_featured) {
        this.marvel_featured = marvel_featured;
    }

    public String getMarvel_description() {
        return marvel_description;
    }

    public void setMarvel_description(String marvel_description) {
        this.marvel_description = marvel_description;
    }

    @Override
    public String toString() {
        return "MarvelMovie{" +
                "id='" + id + '\'' +
                ", marvel_title='" + marvel_title + '\'' +
                ", marvel_price=" + marvel_price +
                ", marvel_synopsis='" + marvel_synopsis + '\'' +
                ", marvel_tag='" + marvel_tag + '\'' +
                ", marvel_small_poster='" + marvel_small_poster + '\'' +
                ", marvel_large_poster='" + marvel_large_poster + '\'' +
                ", marvel_rent=" + marvel_rent +
                ", marvel_purchase_outright=" + marvel_purchase_outright +
                ", marvel_featured='" + marvel_featured + '\'' +
                ", marvel_description='" + marvel_description + '\'' +
                '}';
    }
}
