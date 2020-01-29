package com.shatsi.bed.mainservice.domain.repository;

import com.shatsi.bed.mainservice.domain.model.Apartment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.mapping.CassandraPersistentEntity;
import org.springframework.data.cassandra.repository.query.CassandraEntityInformation;
import org.springframework.data.cassandra.repository.support.MappingCassandraEntityInformation;

import java.util.UUID;

@Configuration
public class ApartmentConfig {

  @Bean
  public ApartmentRepository apartmentRepository(final CassandraTemplate cassandraTemplate) {
    final CassandraPersistentEntity<?> entity = cassandraTemplate.getConverter().getMappingContext().getRequiredPersistentEntity(Apartment.class);
    final CassandraEntityInformation<Apartment, UUID> metadata = new MappingCassandraEntityInformation<>((CassandraPersistentEntity<Apartment>) entity, cassandraTemplate.getConverter());
    return new ApartmentRepositoryImpl(metadata, cassandraTemplate);
  }
}
