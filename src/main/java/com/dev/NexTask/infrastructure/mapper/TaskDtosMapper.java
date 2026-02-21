package com.dev.NexTask.infrastructure.mapper;

import com.dev.NexTask.core.entities.Task;
import com.dev.NexTask.infrastructure.dtos.TaskRequestDTO;
import com.dev.NexTask.infrastructure.dtos.TaskResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class TaskDtosMapper {

    public Task toDomain(TaskRequestDTO dto){

        return new Task(dto.title(), dto.description());

    }

    public TaskResponseDTO toResponse(Task task){
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreatedAt()
        );

    }










}