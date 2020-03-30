package com.toggl.collector.db.repository;

import com.toggl.collector.db.entity.TimeEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeEntryRepository extends JpaRepository<TimeEntryEntity, Long> {
}