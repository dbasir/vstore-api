package com.example.restapimongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tvshows")
public class TVShow
{
    @Id
    private String id;
    private String tvshows_title;
    private double tvshows_price;
    private String tvshows_synopsis;
    private String tvshows_tag;    //Marvel or DC or TV Shows
    private String tvshows_small_poster;
    private String tvshows_large_poster;
    private double tvshows_rent;
    private double tvshows_purchase_outright;
    private String tvshows_featured; //yes or no
    private String tvshows_description;

    public TVShow(){}

    public TVShow(String id, String tvshows_title, double tvshows_price, String tvshows_synopsis, String tvshows_tag, String tvshows_small_poster, String tvshows_large_poster, double tvshows_rent, double tvshows_purchase_outright, String tvshows_featured, String tvshows_description) {
        this.id = id;
        this.tvshows_title = tvshows_title;
        this.tvshows_price = tvshows_price;
        this.tvshows_synopsis = tvshows_synopsis;
        this.tvshows_tag = tvshows_tag;
        this.tvshows_small_poster = tvshows_small_poster;
        this.tvshows_large_poster = tvshows_large_poster;
        this.tvshows_rent = tvshows_rent;
        this.tvshows_purchase_outright = tvshows_purchase_outright;
        this.tvshows_featured = tvshows_featured;
        this.tvshows_description = tvshows_description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTvshows_title() {
        return tvshows_title;
    }

    public void setTvshows_title(String tvshows_title) {
        this.tvshows_title = tvshows_title;
    }

    public double getTvshows_price() {
        return tvshows_price;
    }

    public void setTvshows_price(double tvshows_price) {
        this.tvshows_price = tvshows_price;
    }

    public String getTvshows_synopsis() {
        return tvshows_synopsis;
    }

    public void setTvshows_synopsis(String tvshows_synopsis) {
        this.tvshows_synopsis = tvshows_synopsis;
    }

    public String getTvshows_tag() {
        return tvshows_tag;
    }

    public void setTvshows_tag(String tvshows_tag) {
        this.tvshows_tag = tvshows_tag;
    }

    public String getTvshows_small_poster() {
        return tvshows_small_poster;
    }

    public void setTvshows_small_poster(String tvshows_small_poster) {
        this.tvshows_small_poster = tvshows_small_poster;
    }

    public String getTvshows_large_poster() {
        return tvshows_large_poster;
    }

    public void setTvshows_large_poster(String tvshows_large_poster) {
        this.tvshows_large_poster = tvshows_large_poster;
    }

    public double getTvshows_rent() {
        return tvshows_rent;
    }

    public void setTvshows_rent(double tvshows_rent) {
        this.tvshows_rent = tvshows_rent;
    }

    public double getTvshows_purchase_outright() {
        return tvshows_purchase_outright;
    }

    public void setTvshows_purchase_outright(double tvshows_purchase_outright) {
        this.tvshows_purchase_outright = tvshows_purchase_outright;
    }

    public String getTvshows_featured() {
        return tvshows_featured;
    }

    public void setTvshows_featured(String tvshows_featured) {
        this.tvshows_featured = tvshows_featured;
    }

    public String getTvshows_description() {
        return tvshows_description;
    }

    public void setTvshows_description(String tvshows_description) {
        this.tvshows_description = tvshows_description;
    }

    @Override
    public String toString() {
        return "TVShow{" +
                "id='" + id + '\'' +
                ", tvshows_title='" + tvshows_title + '\'' +
                ", tvshows_price=" + tvshows_price +
                ", tvshows_synopsis='" + tvshows_synopsis + '\'' +
                ", tvshows_tag='" + tvshows_tag + '\'' +
                ", tvshows_small_poster='" + tvshows_small_poster + '\'' +
                ", tvshows_large_poster='" + tvshows_large_poster + '\'' +
                ", tvshows_rent=" + tvshows_rent +
                ", tvshows_purchase_outright=" + tvshows_purchase_outright +
                ", tvshows_featured='" + tvshows_featured + '\'' +
                ", tvshows_description='" + tvshows_description + '\'' +
                '}';
    }
}
