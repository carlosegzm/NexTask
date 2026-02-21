package com.dev.NexTask.core.usecases;

import com.dev.NexTask.core.entities.Task;
import com.dev.NexTask.core.enums.TaskStatus;
import com.dev.NexTask.core.exceptions.TaskNotFoundException;
import com.dev.NexTask.core.gateway.TaskGateway;

public class ChangeStatusUseCaseImpl implements ChangeStatusUseCase {

    private final TaskGateway taskGateway;

    public ChangeStatusUseCaseImpl(TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    @Override
    public Task execute(Long id, TaskStatus status) {
        Task task = taskGateway.getTask(id)
                .orElseThrow(()-> new TaskNotFoundException("Task with Id "+id+" not found."));

        task.changeStatus(status);

        return taskGateway.save(task);
    }

}