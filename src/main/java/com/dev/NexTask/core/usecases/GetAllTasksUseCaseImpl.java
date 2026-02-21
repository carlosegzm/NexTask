package com.dev.NexTask.core.usecases;

import com.dev.NexTask.core.entities.Task;
import com.dev.NexTask.core.gateway.TaskGateway;

import java.util.List;

public class GetAllTasksUseCaseImpl implements GetAllTasksUseCase{

    private final TaskGateway taskGateway;

    public GetAllTasksUseCaseImpl(TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    @Override
    public List<Task> execute() {
        return taskGateway.getAllTasks();
    }
}
