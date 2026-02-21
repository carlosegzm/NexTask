package com.dev.NexTask.core.usecases;

import com.dev.NexTask.core.exceptions.TaskNotFoundException;
import com.dev.NexTask.core.gateway.TaskGateway;

public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase{

    private final TaskGateway taskGateway;

    public DeleteTaskUseCaseImpl(TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    @Override
    public void execute(Long id) {
        taskGateway.getTask(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with Id "+id+" not found."));

        taskGateway.deleteTask(id);
    }
}
