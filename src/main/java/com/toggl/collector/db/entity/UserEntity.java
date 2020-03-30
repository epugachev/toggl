package com.toggl.collector.db.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_ref")
public class UserEntity {
    @Id
    private Long id;
    @Column(name = "api_token")
    private String apiToken;
    @Column(name = "full_name")
    private String fullName;
    @ManyToOne
    @JoinColumn(name = "default_workspace_id")
    private WorkspaceEntity defaultWorkspace;
}