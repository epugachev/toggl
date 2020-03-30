package com.toggl.collector.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "time_entry_jn")
public class TimeEntryEntity {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "workspace_id")
    private WorkspaceEntity workspace;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity project;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    //добавить поддержку тегов

    private Long duration;
    @Column(name = "\"desc\"")
    private String description;

    private LocalDateTime at;
    private LocalDateTime start;
    private LocalDateTime stop;
}