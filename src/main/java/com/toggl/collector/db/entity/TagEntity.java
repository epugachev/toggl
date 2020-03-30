package com.toggl.collector.db.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tag_ref")
public class TagEntity {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "workspace_id")
    private WorkspaceEntity workspace;
}