package com.shatsi.bed.mainservice.domain.repository;

import com.shatsi.bed.mainservice.domain.model.Apartment;
import com.shatsi.bed.mainservice.domain.model.ApartmentByUser;
import com.shatsi.bed.mainservice.domain.model.ApartmentByUserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraBatchOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.query.CassandraEntityInformation;
import org.springframework.data.cassandra.repository.support.SimpleCassandraRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;
public class ApartmentRepositoryImpl extends SimpleCassandraRepository<Apartment, UUID> implements ApartmentRepository {
    private CassandraTemplate cassandraTemplate;

    ApartmentRepositoryImpl(final  CassandraEntityInformation<Apartment, UUID> metadata, final  CassandraTemplate cassandraTemplate){
        super(metadata,cassandraTemplate);
        this.cassandraTemplate = cassandraTemplate;
    }
    @Override
    public <S extends Apartment> S insert(S apartment){
        CassandraBatchOperations batchOps = cassandraTemplate.batchOps();
        insertApartmentByUser(apartment,batchOps);
        batchOps.insert(apartment);
        batchOps.execute();
        return apartment;
    }
    private void insertApartmentByUser(Apartment apartment,CassandraBatchOperations batchOps ){
        ApartmentByUserKey key = new ApartmentByUserKey(apartment.getOwner().getUuid(),apartment.getCreated(),apartment.getId());
        ApartmentByUser apartmentByUser = new ApartmentByUser(key,apartment.getTitle(),apartment.getDetails(),apartment.getLocation(),apartment.getImageUrl(),apartment.getPrice());
        batchOps.insert(apartmentByUser);
    }
}
