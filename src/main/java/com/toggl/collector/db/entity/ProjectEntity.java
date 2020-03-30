package com.toggl.collector.db.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "project_ref")
public class ProjectEntity {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "workspace_id")
    private WorkspaceEntity workspace;
}