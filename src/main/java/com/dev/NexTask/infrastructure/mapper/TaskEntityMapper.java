package com.dev.NexTask.infrastructure.mapper;

import com.dev.NexTask.core.entities.Task;
import com.dev.NexTask.infrastructure.persistence.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskEntityMapper {

    public TaskEntity toEntity(Task task){
        return new TaskEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreatedAt(),
                task.getStatus()
        );

    }

    public Task toDomain(TaskEntity taskEntity){
        return new Task(
                taskEntity.getId(),
                taskEntity.getTitle(),
                taskEntity.getDescription(),
                taskEntity.getCreatedAt(),
                taskEntity.getStatus()
        );

    }

}