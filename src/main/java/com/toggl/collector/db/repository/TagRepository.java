package com.toggl.collector.db.repository;

import com.toggl.collector.db.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
}