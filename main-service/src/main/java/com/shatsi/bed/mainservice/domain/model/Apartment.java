package com.shatsi.bed.mainservice.domain.model;

import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Table("apartments")
public class Apartment {
    @PrimaryKey
    private UUID id;
    @Column("apartment_id")
    private String apartmentId;
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
    @Column
    private LocalDateTime created;
    @Transient
    private User owner;

    public Apartment() {
    }


    public Apartment(UUID id, String apartmentId, String title, String details, String location, String imageUrl, Double price, LocalDateTime created) {
        this.id = id;
        this.apartmentId = apartmentId;
        this.title = title;
        this.details = details;
        this.location = location;
        this.imageUrl = imageUrl;
        this.price = price;
        this.created = created;
    }

    public Apartment(UUID id, String apartmentId, String title, String details, String location, String imageUrl, Double price, LocalDateTime created, User owner) {
        this.id = id;
        this.apartmentId = apartmentId;
        this.title = title;
        this.details = details;
        this.location = location;
        this.imageUrl = imageUrl;
        this.price = price;
        this.created = created;
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(String apartmentId) {
        this.apartmentId = apartmentId;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", apartmentId='" + apartmentId + '\'' +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", location='" + location + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", created=" + created +
                '}';
    }
}
