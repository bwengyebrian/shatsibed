package com.shatsi.bed.mainservice.domain.repository;

import com.shatsi.bed.mainservice.domain.model.Apartment;
import com.shatsi.bed.mainservice.domain.model.ApartmentByUser;
import com.shatsi.bed.mainservice.domain.model.ApartmentByUserKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface ApartmentByUserRepository extends CassandraRepository<ApartmentByUser, ApartmentByUserKey> {
    List<ApartmentByUser> findApartmentByKeyUserId(UUID userId);
}
