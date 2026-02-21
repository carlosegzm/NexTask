package com.dev.NexTask.core.usecases;

import com.dev.NexTask.core.entities.Task;
import com.dev.NexTask.core.exceptions.TaskNotFoundException;
import com.dev.NexTask.core.gateway.TaskGateway;

public class GetTaskUseCaseImpl implements GetTaskUseCase{

    private final TaskGateway taskGateway;

    public GetTaskUseCaseImpl(TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    @Override
    public Task execute(Long id) {
        return taskGateway.getTask(id)
                .orElseThrow(()-> new TaskNotFoundException("Task with Id "+id+" not found."));
    }
}
