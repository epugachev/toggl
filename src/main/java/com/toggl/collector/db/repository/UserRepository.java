package com.toggl.collector.db.repository;

import com.toggl.collector.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByApiToken(@Param("apiToken") String apiToken);
}