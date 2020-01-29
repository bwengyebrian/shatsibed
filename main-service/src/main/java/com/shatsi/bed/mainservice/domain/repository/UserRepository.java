package com.shatsi.bed.mainservice.domain.repository;

import com.shatsi.bed.mainservice.domain.model.User;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface UserRepository extends CassandraRepository<User, UUID> {
}
