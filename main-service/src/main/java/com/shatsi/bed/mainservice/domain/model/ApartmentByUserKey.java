package com.shatsi.bed.mainservice.domain.model;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@PrimaryKeyClass
public class ApartmentByUserKey implements Serializable {
    @PrimaryKeyColumn(name = "user_id",type = PrimaryKeyType.PARTITIONED)
    private UUID userId;
    @PrimaryKeyColumn(name = "apartment_created", type = PrimaryKeyType.CLUSTERED, ordinal = 0,ordering = Ordering.DESCENDING)
    private LocalDateTime apartmentCreated;
    @PrimaryKeyColumn(name = "apartment_id", type = PrimaryKeyType.CLUSTERED, ordinal = 1,ordering = Ordering.DESCENDING )
    private UUID apartmentId;


    public ApartmentByUserKey() {
    }

    public ApartmentByUserKey(UUID userId, LocalDateTime apartmentCreated, UUID apartmentId) {
        this.userId = userId;
        this.apartmentCreated = apartmentCreated;
        this.apartmentId = apartmentId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public LocalDateTime getApartmentCreated() {
        return apartmentCreated;
    }

    public void setApartmentCreated(LocalDateTime apartmentCreated) {
        this.apartmentCreated = apartmentCreated;
    }

    public UUID getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(UUID apartmentId) {
        this.apartmentId = apartmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentByUserKey that = (ApartmentByUserKey) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(apartmentCreated, that.apartmentCreated) &&
                Objects.equals(apartmentId, that.apartmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, apartmentCreated, apartmentId);
    }

    @Override
    public String toString() {
        return "ApartmentByUserKey{" +
                "userId=" + userId +
                ", apartmentCreated=" + apartmentCreated +
                ", apartmentId=" + apartmentId +
                '}';
    }
}
