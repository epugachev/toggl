package com.toggl.collector.db.repository;

import com.toggl.collector.db.entity.WorkspaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepository extends JpaRepository<WorkspaceEntity, Long> {
}