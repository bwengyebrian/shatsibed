package com.shatsi.bed.mainservice.domain.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("apartments_by_user")
public class ApartmentByUser {
    @PrimaryKey
    private ApartmentByUserKey key;
    @Column("title")
    private String title;
    @Column
    private String details;
    @Column
    private String location;
    @Column
    private String imageUrl;
    @Column
    private Double price;

    public ApartmentByUser() {
    }

    public ApartmentByUser(ApartmentByUserKey key, String title, String details, String location, String imageUrl, Double price) {
        this.key = key;
        this.title = title;
        this.details = details;
        this.location = location;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public ApartmentByUserKey getKey() {
        return key;
    }

    public void setKey(ApartmentByUserKey key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ApartmentByUser{" +
                "key=" + key +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", location='" + location + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                '}';
    }
}
