package com.toggl.collector.db.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "workspace_ref")
public class WorkspaceEntity {
    @Id
    private Long id;
    private String name;
    @Column(name = "api_token")
    private String apiToken;
}
