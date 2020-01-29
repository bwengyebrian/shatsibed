package com.shatsi.bed.mainservice.domain.repository;

import com.shatsi.bed.mainservice.domain.model.Apartment;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface ApartmentRepository extends CassandraRepository<Apartment, UUID> {
}
