package com.dev.NexTask.core.usecases;

import com.dev.NexTask.core.entities.Task;
import com.dev.NexTask.core.gateway.TaskGateway;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase{

    private final TaskGateway taskGateway;

    public CreateTaskUseCaseImpl(TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    @Override
    public Task execute(Task task) {
        return taskGateway.save(task);
    }
}
