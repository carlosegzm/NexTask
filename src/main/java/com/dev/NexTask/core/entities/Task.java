package com.dev.NexTask.core.entities;

import com.dev.NexTask.core.enums.TaskStatus;
import com.dev.NexTask.core.exceptions.TaskStateException;

import java.time.LocalDateTime;

public class Task {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private TaskStatus status;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.status = TaskStatus.PENDING;
    }

    public Task(Long id, String title, String description, LocalDateTime createdAt, TaskStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.status = status;
    }

    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("The new status cannot be null.");
        }

        if (this.status == newStatus) {
            return;
        }

        if (this.status == TaskStatus.CANCELED) {
            throw new TaskStateException("Cannot change the status of a canceled task.");
        }

        if (this.status == TaskStatus.PENDING && newStatus == TaskStatus.DONE) {
            throw new TaskStateException("A task must be ACTIVE before it can be marked as DONE.");
        }

        this.status = newStatus;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public TaskStatus getStatus() {
        return status;
    }
}